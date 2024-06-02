package com.example.TravellingAgency.demo.web;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/savecity")
    public City saveCity(@RequestBody City city) {
        return cityService.save(city);
    }
}

