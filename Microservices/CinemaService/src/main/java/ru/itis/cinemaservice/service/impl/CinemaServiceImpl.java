package ru.itis.cinemaservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.cinemaservice.dto.CinemasPage;
import ru.itis.cinemaservice.model.Cinema;
import ru.itis.cinemaservice.repository.CinemaRepository;
import ru.itis.cinemaservice.service.CinemaService;

import java.util.List;

import static ru.itis.cinemaservice.dto.response.CinemaResponse.from;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    @Override
    public CinemasPage getAllCinemas(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 2);

        Page<Cinema> cinemas = cinemaRepository.findAll(pageRequest);
        List<Cinema> cinemaList = cinemaRepository.findAll();
        return CinemasPage.builder()
                .cinemas(from(cinemaList))
                .totalPages(cinemas.getTotalPages())
                .build();
    }

    @Override
    public CinemasPage getAllCinemasByCity(String city, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 2, Sort.by("id"));

        Page<Cinema> cinemas = cinemaRepository.findAllByCity(city, pageRequest);
        List<Cinema> cinemaList = cinemaRepository.findAllByCity(city);
        return CinemasPage.builder()
                .cinemas(from(cinemaList))
                .totalPages(cinemas.getTotalPages())
                .build();
    }
}
