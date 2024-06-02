package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.Continent;
import com.example.TravellingAgency.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Continent> getContinentById(@PathVariable Long id) {
        Optional<Continent> continent = continentService.findById(id);
        if (continent.isPresent()) {
            return ResponseEntity.ok(continent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Continent createContinent(@RequestBody Continent continent) {
        return continentService.save(continent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Continent> updateContinent(@PathVariable Long id, @RequestBody Continent continentDetails) {
        Optional<Continent> continent = continentService.findById(id);
        if (continent.isPresent()) {
            Continent continentToUpdate = continent.get();
            continentToUpdate.setName(continentDetails.getName());
            continentToUpdate.setCountries(continentDetails.getCountries());
            Continent updatedContinent = continentService.save(continentToUpdate);
            return ResponseEntity.ok(updatedContinent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContinent(@PathVariable Long id) {
        continentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}