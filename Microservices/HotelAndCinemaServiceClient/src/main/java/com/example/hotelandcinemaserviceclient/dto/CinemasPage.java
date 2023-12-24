package com.example.hotelandcinemaserviceclient.dto;

import com.example.hotelandcinemaserviceclient.dto.response.CinemaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemasPage {
    private List<CinemaResponse> cinemas;

    private Integer totalPages;
}
