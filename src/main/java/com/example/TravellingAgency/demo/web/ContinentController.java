package com.example.TravellingAgency.demo.web;

import com.example.TravellingAgency.demo.entity.Continent;
import com.example.TravellingAgency.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @PostMapping("/addContinent")
    public Continent createContinent(@RequestBody Continent continent) {
        return continentService.createContinent(continent);
    }
}
