package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.PurchasingTour;

import java.util.List;

public interface PurchasingTourService {

    PurchasingTour createPurchasingTour(PurchasingTour purchasingTour);

    List<PurchasingTour> getAllPurchasingTours();

    PurchasingTour getPurchasingTourById(Long id);

    PurchasingTour updatePurchasingTour(Long id, PurchasingTour updatedPurchasingTour);

    void deletePurchasingTour(Long id);
}