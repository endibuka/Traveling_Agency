package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        List<City> cities = cityService.findAll();
        cities.forEach(city -> {
            city.getCountry().getName();  // Ensure lazy loading
            city.getCountry().getContinent().getName();  // Ensure lazy loading
        });
        return cities;
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            City foundCity = city.get();
            foundCity.getCountry().getName();  // Ensure lazy loading
            foundCity.getCountry().getContinent().getName();  // Ensure lazy loading
            return ResponseEntity.ok(foundCity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            City cityToUpdate = city.get();
            cityToUpdate.setName(cityDetails.getName());
            cityToUpdate.setCountry(cityDetails.getCountry());
            City updatedCity = cityService.save(cityToUpdate);
            return ResponseEntity.ok(updatedCity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byCountries")
    public List<City> getCitiesByCountryIds(@RequestParam List<Long> countryIds) {
        List<City> cities = cityService.findByCountryIdIn(countryIds);
        cities.forEach(city -> {
            city.getCountry().getName();  // Ensure lazy loading
            city.getCountry().getContinent().getName();  // Ensure lazy loading
        });
        return cities;
    }
}
