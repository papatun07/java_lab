package ru.itis.hotelservice.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.hotelservice.dto.HotelsPage;

@RequestMapping("/api/v1/hotel")
public interface HotelControllerApi {

    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    HotelsPage getAllHotels(@RequestParam("page") Integer page);
    @GetMapping("/info-by-city")
    @ResponseStatus(HttpStatus.OK)
    HotelsPage getAllHotelsByCity(@RequestParam("city") String city, @RequestParam("page") Integer page);
}
