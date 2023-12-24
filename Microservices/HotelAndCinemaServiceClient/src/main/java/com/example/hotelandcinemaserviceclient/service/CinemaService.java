package com.example.hotelandcinemaserviceclient.service;

import com.example.hotelandcinemaserviceclient.dto.CinemasPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cinema-service", url = "${feign.cinema-service.url}")
public interface CinemaService {
    @GetMapping(value = "/api/v1/cinema/info", consumes = MediaType.APPLICATION_JSON_VALUE)
    CinemasPage getAllCinemas(@RequestParam("api-key") String apiKey,
                              @RequestParam("page") Integer page);

    @GetMapping(value = "/api/v1/cinema/info-by-city", consumes = MediaType.APPLICATION_JSON_VALUE)
    CinemasPage getAllCinemasByCity(@RequestParam("city") String city,
                                    @RequestParam("api-key") String apiKey,
                                    @RequestParam("page") Integer page);
}
