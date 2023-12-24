package com.example.hotelandcinemaserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HotelAndCinemaServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAndCinemaServiceClientApplication.class, args);
    }

}






