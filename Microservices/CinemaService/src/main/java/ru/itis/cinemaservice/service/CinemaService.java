package ru.itis.cinemaservice.service;

import ru.itis.cinemaservice.dto.CinemasPage;

public interface CinemaService {
    CinemasPage getAllCinemas(Integer page);

    CinemasPage getAllCinemasByCity(String city, Integer page);
}
