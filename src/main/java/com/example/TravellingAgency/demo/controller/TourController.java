package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.Tour;
import com.example.TravellingAgency.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable int id) {
        Optional<Tour> tour = tourService.findById(id);
        if (tour.isPresent()) {
            return ResponseEntity.ok(tour.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable int id, @RequestBody Tour tourDetails) {
        Optional<Tour> tour = tourService.findById(id);
        if (tour.isPresent()) {
            Tour tourToUpdate = tour.get();
            tourToUpdate.setFromCity(tourDetails.getFromCity());
            tourToUpdate.setFromAirport(tourDetails.getFromAirport());
            tourToUpdate.setToCity(tourDetails.getToCity());
            tourToUpdate.setToAirport(tourDetails.getToAirport());
            tourToUpdate.setDepartureDate(tourDetails.getDepartureDate());
            tourToUpdate.setDateOfReturn(tourDetails.getDateOfReturn());
            tourToUpdate.setNumberOfDays(tourDetails.getNumberOfDays());
            tourToUpdate.setType(tourDetails.getType());
            tourToUpdate.setPriceForAdult(tourDetails.getPriceForAdult());
            tourToUpdate.setPriceForChild(tourDetails.getPriceForChild());
            tourToUpdate.setPromoted(tourDetails.isPromoted());
            tourToUpdate.setNumberOfAdultSeats(tourDetails.getNumberOfAdultSeats());
            tourToUpdate.setNumberOfPlacesForChildren(tourDetails.getNumberOfPlacesForChildren());
            Tour updatedTour = tourService.save(tourToUpdate);
            return ResponseEntity.ok(updatedTour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable int id) {
        tourService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}