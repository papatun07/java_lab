package com.example.hotelandcinemaserviceclient.controller;

import com.example.hotelandcinemaserviceclient.dto.CinemasPage;
import com.example.hotelandcinemaserviceclient.dto.HotelsPage;
import com.example.hotelandcinemaserviceclient.dto.InfoDto;
import com.example.hotelandcinemaserviceclient.service.CinemaService;
import com.example.hotelandcinemaserviceclient.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InfoController {
    private final HotelService hotelService;
    private final CinemaService cinemaService;

    @GetMapping("/info")
    public ResponseEntity<InfoDto> getInfo(@RequestParam("page") Integer page) {
        HotelsPage hotelsPage = hotelService.getAllHotels("hotel-api-key",page);
        CinemasPage cinemasPage = cinemaService.getAllCinemas("cinema-api-key", page);

        return ResponseEntity.ok(InfoDto.builder()
                .cinemas(cinemasPage.getCinemas())
                .hotels(hotelsPage.getHotels())
                .build());
    }
    @GetMapping("/info-by-city")
    public ResponseEntity<InfoDto> getInfoByCity(@RequestParam("city") String city,
                                                 @RequestParam("page") Integer page) {
        HotelsPage hotelsPage = hotelService.getAllHotelsByCity(city, "hotel-api-key", page);
        CinemasPage cinemasPage = cinemaService.getAllCinemasByCity(city, "cinema-api-key", page);

        return ResponseEntity.ok(InfoDto.builder()
                .cinemas(cinemasPage.getCinemas())
                .hotels(hotelsPage.getHotels())
                .build());
    }
}
