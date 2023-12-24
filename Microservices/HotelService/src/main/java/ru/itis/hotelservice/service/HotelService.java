package ru.itis.hotelservice.service;

import ru.itis.hotelservice.dto.HotelsPage;

public interface HotelService {
    HotelsPage getAllHotels(Integer page);

    HotelsPage getAllHotelsByCity(String city, Integer page);
}
