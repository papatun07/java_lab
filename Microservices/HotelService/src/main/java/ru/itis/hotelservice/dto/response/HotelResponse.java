package ru.itis.hotelservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.hotelservice.model.Hotel;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponse {
    private Long id;

    private String title;

    private String city;

    public static HotelResponse from(Hotel hotel){
        return HotelResponse.builder()
                .id(hotel.getId())
                .title(hotel.getTitle())
                .city(hotel.getCity())
                .build();
    }

    public static List<HotelResponse> from(List<Hotel> hotels){
        return hotels.stream()
                .map(HotelResponse::from)
                .toList();
    }
}
