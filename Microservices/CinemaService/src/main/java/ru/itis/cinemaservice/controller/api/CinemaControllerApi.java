package ru.itis.cinemaservice.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.cinemaservice.dto.CinemasPage;

@RequestMapping("/api/v1/cinema")
public interface CinemaControllerApi {
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    CinemasPage getAllCinemas(@RequestParam("page") Integer page);
    @GetMapping("/info-by-city")
    @ResponseStatus(HttpStatus.OK)
    CinemasPage getAllCinemasByCity(@RequestParam("city") String city, @RequestParam("page") Integer page);
}
