package com.example.hotelandcinemaserviceclient.service;

import com.example.hotelandcinemaserviceclient.dto.HotelsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hotel-service", url = "${feign.hotel-service.url}")
public interface HotelService {
    @GetMapping(value = "/api/v1/hotel/info", consumes = MediaType.APPLICATION_JSON_VALUE)
    HotelsPage getAllHotels(@RequestParam("api-key") String apiKey,
                            @RequestParam("page") Integer page);

    @GetMapping(value = "/api/v1/hotel/info-by-city", consumes = MediaType.APPLICATION_JSON_VALUE)
    HotelsPage getAllHotelsByCity(@RequestParam("city") String city,
                                  @RequestParam("api-key") String apiKey,
                                  @RequestParam("page") Integer page);
}
