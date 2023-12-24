package ru.itis.cinemaservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.cinemaservice.model.Cinema;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Page<Cinema> findAllByCity(String city, Pageable pageable);
    List<Cinema> findAllByCity(String city);
}
