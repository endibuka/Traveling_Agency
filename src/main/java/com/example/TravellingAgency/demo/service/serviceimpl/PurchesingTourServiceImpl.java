package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.PurchesingTour;
import com.example.TravellingAgency.demo.repository.PurchesingTourRepository;
import com.example.TravellingAgency.demo.service.PurchesingTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchesingTourServiceImpl implements PurchesingTourService {

    @Autowired
    private PurchesingTourRepository purchesingTourRepository;

    @Override
    public PurchesingTour createPurchesingTour(PurchesingTour purchesingTour) {
        return purchesingTourRepository.save(purchesingTour);
    }

    @Override
    public List<PurchesingTour> getAllPurchesingTours() {
        return purchesingTourRepository.findAll();
    }

    @Override
    public PurchesingTour getPurchesingTourById(Long id) {
        return purchesingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchesing Tour not found with id: " + id));
    }

    @Override
    public PurchesingTour updatePurchesingTour(Long id, PurchesingTour updatedPurchesingTour) {
        PurchesingTour purchesingTour = purchesingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchesing Tour not found with id: " + id));
        // Update fields of the purchesingTour object with the fields of updatedPurchesingTour
        // Remember to handle each field according to your application's requirements
        return purchesingTourRepository.save(purchesingTour);
    }

    @Override
    public void deletePurchesingTour(Long id) {
        PurchesingTour purchesingTour = purchesingTourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchesing Tour not found with id: " + id));
        purchesingTourRepository.delete(purchesingTour);
    }
}
