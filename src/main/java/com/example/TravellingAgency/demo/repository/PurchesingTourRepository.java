package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.PurchesingTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchesingTourRepository extends JpaRepository<PurchesingTour, Long> {
    // You can define additional methods here if needed
}
