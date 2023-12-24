package com.example.hotelandcinemaserviceclient.dto;

import com.example.hotelandcinemaserviceclient.dto.response.HotelResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelsPage {
    private List<HotelResponse> hotels;

    private Integer totalPages;
}
