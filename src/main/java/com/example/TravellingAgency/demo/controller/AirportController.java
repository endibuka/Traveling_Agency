package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.Airport;
import com.example.TravellingAgency.demo.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.findById(id);
        if (airport.isPresent()) {
            return ResponseEntity.ok(airport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.save(airport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airportDetails) {
        Optional<Airport> airport = airportService.findById(id);
        if (airport.isPresent()) {
            Airport airportToUpdate = airport.get();
            airportToUpdate.setName(airportDetails.getName());
            airportToUpdate.setCode(airportDetails.getCode());
            airportToUpdate.setCity(airportDetails.getCity());
            Airport updatedAirport = airportService.save(airportToUpdate);
            return ResponseEntity.ok(updatedAirport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}