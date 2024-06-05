package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> findAll();

    Optional<Airport> findById(Long id);

    Airport save(Airport airport);

    void deleteById(Long id);
}