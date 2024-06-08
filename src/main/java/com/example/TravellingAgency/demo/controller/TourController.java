package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.PromotionStatus;
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
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        if (tour.getPromoted() == null) {
            tour.setPromoted(PromotionStatus.NO);  // Set default if not provided
        }
        Tour savedTour = tourService.save(tour);
        return ResponseEntity.ok(savedTour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable int id, @RequestBody Tour tourDetails) {
        return tourService.findById(id)
                .map(existingTour -> {
                    existingTour.setFromCity(tourDetails.getFromCity());
                    existingTour.setFromAirport(tourDetails.getFromAirport());
                    existingTour.setToCity(tourDetails.getToCity());
                    existingTour.setToAirport(tourDetails.getToAirport());
                    existingTour.setDepartureDate(tourDetails.getDepartureDate());
                    existingTour.setDateOfReturn(tourDetails.getDateOfReturn());
                    existingTour.setNumberOfDays(tourDetails.getNumberOfDays());
                    existingTour.setType(tourDetails.getType());
                    existingTour.setPriceOfTour(tourDetails.getPriceOfTour());
                    existingTour.setNumberOfSeats(tourDetails.getNumberOfSeats());
                    return ResponseEntity.ok(tourService.save(existingTour));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/promotion")
    public ResponseEntity<?> updatePromotion(@PathVariable int id, @RequestParam PromotionStatus promotionStatus, @RequestParam(required = false) Double discountPercentage) {
        try {
            Tour updatedTour = tourService.updatePromotion(id, promotionStatus, discountPercentage);
            return ResponseEntity.ok(updatedTour);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid parameters: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable int id) {
        tourService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Tour>> filterTours(
            @RequestParam(required = false) Long fromCityId,
            @RequestParam(required = false) Long toCityId) {
        List<Tour> tours;
        if (fromCityId != null && toCityId != null) {
            City fromCity = new City();
            fromCity.setId(fromCityId);
            City toCity = new City();
            toCity.setId(toCityId);
            tours = tourService.findByFromCityAndToCity(fromCity, toCity);
        } else if (fromCityId != null) {
            City fromCity = new City();
            fromCity.setId(fromCityId);
            tours = tourService.findByFromCity(fromCity);
        } else if (toCityId != null) {
            City toCity = new City();
            toCity.setId(toCityId);
            tours = tourService.findByToCity(toCity);
        } else {
            tours = tourService.findAll();
        }
        return ResponseEntity.ok(tours);
    }
    @GetMapping("/sorted-by-price")
    public List<Tour> getToursSortedByPrice(@RequestParam double priceOfTour) {
        return tourService.findAllByOrderByPriceAsc(priceOfTour);
    }
    @GetMapping("/sorted-by-price-desc")
    public List<Tour> getToursSortedByPriceDesc(@RequestParam double priceOfTour) {
        return tourService.findAllByOrderByPriceDesc(priceOfTour);
    }

    @PostMapping("/total-price")
    public double calculateTotalPrice(@RequestBody List<Integer> tourIds) {
        return tourService.calculateTotalPrice(tourIds);
    }

}
