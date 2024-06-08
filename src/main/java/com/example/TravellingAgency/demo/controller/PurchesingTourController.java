package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.PurchasingTour;
import com.example.TravellingAgency.demo.service.PurchasingTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchesingTours")
public class PurchesingTourController {

    @Autowired
    private PurchasingTourService purchasingTourService;

    // Create
    @PostMapping
    public PurchasingTour createPurchasingTour(@RequestBody PurchasingTour purchasingTour) {
        return purchasingTourService.createPurchasingTour(purchasingTour);
    }

    // Read all
    @GetMapping
    public List<PurchasingTour> getAllPurchasingTours() {
        return purchasingTourService.getAllPurchasingTours();
    }

    // Read by id
    @GetMapping("/{id}")
    public PurchasingTour getPurchasingTourById(@PathVariable Long id) {
        return purchasingTourService.getPurchasingTourById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PurchasingTour updatePurchasingTour(@PathVariable Long id, @RequestBody PurchasingTour updatedPurchasingTour) {
        return purchasingTourService.updatePurchasingTour(id, updatedPurchasingTour);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletePurchasingTour(@PathVariable Long id) {
        purchasingTourService.deletePurchasingTour(id);
        return "Purchasing Tour deleted successfully";
    }
}