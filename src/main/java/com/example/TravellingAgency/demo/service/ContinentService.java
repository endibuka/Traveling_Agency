package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Continent;

import java.util.List;
import java.util.Optional;

public interface ContinentService {
    List<Continent> findAll();
    Optional<Continent> findById(Long id);
    Continent save(Continent continent);
    void deleteById(Long id);
}