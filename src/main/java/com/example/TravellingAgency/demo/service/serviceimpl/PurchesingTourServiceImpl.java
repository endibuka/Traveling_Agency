package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.PurchasingTour;
import com.example.TravellingAgency.demo.repository.PurchasingTourRepository;
import com.example.TravellingAgency.demo.service.PurchasingTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchesingTourServiceImpl implements PurchasingTourService {

    @Autowired
    private PurchasingTourRepository purchasingTourRepository;

    @Override
    public PurchasingTour createPurchasingTour(PurchasingTour purchasingTour) {
        return purchasingTourRepository.save(purchasingTour);
    }

    @Override
    public List<PurchasingTour> getAllPurchasingTours() {
        return purchasingTourRepository.findAll();
    }

    @Override
    public PurchasingTour getPurchasingTourById(Long id) {
        return purchasingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchasing Tour not found with id: " + id));
    }

    @Override
    public PurchasingTour updatePurchasingTour(Long id, PurchasingTour updatedPurchasingTour) {
        PurchasingTour purchasingTour = purchasingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchasing Tour not found with id: " + id));
        // Update fields of the purchasingTour object with the fields of updatedPurchasingTour
        // Remember to handle each field according to your application's requirements
        return purchasingTourRepository.save(purchasingTour);
    }

    @Override
    public void deletePurchasingTour(Long id) {
        PurchasingTour purchasingTour = purchasingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchasing Tour not found with id: " + id));
        purchasingTourRepository.delete(purchasingTour);
    }
}
