package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.City;
import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    void deleteById(Long id);
    List<City> findByCountryIdIn(List<Long> countryIds);
}