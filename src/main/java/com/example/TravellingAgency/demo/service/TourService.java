package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> findAll();

    Optional<Tour> findById(int id);

    Tour save(Tour tour);

    void deleteById(int id);
}