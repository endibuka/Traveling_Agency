package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Hotel;
import com.example.TravellingAgency.demo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}

