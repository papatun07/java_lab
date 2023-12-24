package ru.itis.hotelservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.hotelservice.controller.api.HotelControllerApi;
import ru.itis.hotelservice.dto.HotelsPage;
import ru.itis.hotelservice.service.HotelService;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelControllerApi {
    private final HotelService hotelService;
    @Override
    public HotelsPage getAllHotels(Integer page) {
        return hotelService.getAllHotels(page);
    }

    @Override
    public HotelsPage getAllHotelsByCity(String city, Integer page) {
        return hotelService.getAllHotelsByCity(city, page);
    }
}
