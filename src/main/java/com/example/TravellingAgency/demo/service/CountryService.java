package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Country;
import com.example.TravellingAgency.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country save(Country country) {
        return countryRepository.save(country);
    }
}

