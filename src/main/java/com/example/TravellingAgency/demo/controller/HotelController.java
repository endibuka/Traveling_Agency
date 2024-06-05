package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.Hotel;
import com.example.TravellingAgency.demo.service.CityService;
import com.example.TravellingAgency.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelService.findById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
        Optional<Hotel> hotel = hotelService.findById(id);
        if (hotel.isPresent()) {
            Hotel hotelToUpdate = hotel.get();
            hotelToUpdate.setName(hotelDetails.getName());
            hotelToUpdate.setStandard(hotelDetails.getStandard());
            hotelToUpdate.setDescription(hotelDetails.getDescription());
            hotelToUpdate.setCity(hotelDetails.getCity());
            Hotel updatedHotel = hotelService.save(hotelToUpdate);
            return ResponseEntity.ok(updatedHotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/Hotels")
    public List<Hotel> getHtelsByCityIds(@RequestParam List<Long> cityIds) {
        return hotelService.findByCityIdIn(cityIds);
    }
}