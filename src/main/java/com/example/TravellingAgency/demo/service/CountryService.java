package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void deleteById(Long id);
}
