package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(Long id);
    Hotel save(Hotel hotel);
    void deleteById(Long id);
    List<Hotel> findByCityIdIn(List<Long> cityIds);
}