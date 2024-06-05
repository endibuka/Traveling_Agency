package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.Uzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzerRepository extends JpaRepository<Uzer, Long> {
    // You can define additional methods here if needed
}