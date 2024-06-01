package com.example.TravellingAgency.demo.web;

import com.example.TravellingAgency.demo.entity.Country;
import com.example.TravellingAgency.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country saveCountry(@RequestBody Country country) {
        return countryService.save(country);
    }
}

