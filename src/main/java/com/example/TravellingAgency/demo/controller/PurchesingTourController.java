package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.PurchesingTour;
import com.example.TravellingAgency.demo.service.PurchesingTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchesingTours")
public class PurchesingTourController {

    @Autowired
    private PurchesingTourService purchesingTourService;

    // Create
    @PostMapping
    public PurchesingTour createPurchesingTour(@RequestBody PurchesingTour purchesingTour) {
        return purchesingTourService.createPurchesingTour(purchesingTour);
    }

    // Read all
    @GetMapping
    public List<PurchesingTour> getAllPurchesingTours() {
        return purchesingTourService.getAllPurchesingTours();
    }

    // Read by id
    @GetMapping("/{id}")
    public PurchesingTour getPurchesingTourById(@PathVariable Long id) {
        return purchesingTourService.getPurchesingTourById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PurchesingTour updatePurchesingTour(@PathVariable Long id, @RequestBody PurchesingTour updatedPurchesingTour) {
        return purchesingTourService.updatePurchesingTour(id, updatedPurchesingTour);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletePurchesingTour(@PathVariable Long id) {
        purchesingTourService.deletePurchesingTour(id);
        return "Purchesing Tour deleted successfully";
    }
}