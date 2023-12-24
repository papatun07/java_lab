package ru.itis.hotelservice.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.hotelservice.security.authentication.ApiKeyAuthentication;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
    // GET localhost:8080/api/tasks?api-key=.....
    private static final String API_KEY_PARAMETER_NAME = "api-key";

    private final AuthenticationManager authenticationManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getParameter(API_KEY_PARAMETER_NAME);

        if (apiKey != null) {
            SecurityContextHolder.getContext().setAuthentication(
                    authenticationManager.authenticate(new ApiKeyAuthentication(AuthorityUtils.NO_AUTHORITIES, apiKey))
            );
        }

        filterChain.doFilter(request, response);

    }
}
