package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.PurchasingTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingTourRepository extends JpaRepository<PurchasingTour, Long> {
    // You can define additional methods here if needed
}
