package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.PurchesingTour;

import java.util.List;

public interface PurchesingTourService {

    PurchesingTour createPurchesingTour(PurchesingTour purchesingTour);

    List<PurchesingTour> getAllPurchesingTours();

    PurchesingTour getPurchesingTourById(Long id);

    PurchesingTour updatePurchesingTour(Long id, PurchesingTour updatedPurchesingTour);

    void deletePurchesingTour(Long id);
}