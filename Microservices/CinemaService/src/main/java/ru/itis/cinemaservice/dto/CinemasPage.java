package ru.itis.cinemaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.cinemaservice.dto.response.CinemaResponse;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemasPage {
    private List<CinemaResponse> cinemas;

    private Integer totalPages;
}
