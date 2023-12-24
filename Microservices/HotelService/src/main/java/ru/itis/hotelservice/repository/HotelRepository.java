package ru.itis.hotelservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hotelservice.model.Hotel;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Page<Hotel> findAllByCity(String city, Pageable pageable);
    List<Hotel> findAllByCity(String city);
}
