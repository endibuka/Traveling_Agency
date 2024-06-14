package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.Country;
import com.example.TravellingAgency.demo.service.CityService;
import com.example.TravellingAgency.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> country = countryService.findById(id);
        if (country.isPresent()) {
            return ResponseEntity.ok(country.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/postCoutry")
    public Country createCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
        Optional<Country> country = countryService.findById(id);
        if (country.isPresent()) {
            Country countryToUpdate = country.get();
            countryToUpdate.setName(countryDetails.getName());
            countryToUpdate.setContinent(countryDetails.getContinent());
            Country updatedCountry = countryService.save(countryToUpdate);
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/Countries")
    public List<City> getCitiesByCountryIds(@RequestParam List<Long> countryIds) {
        return cityService.findByCountryIdIn(countryIds);
    }
}
