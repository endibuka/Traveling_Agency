package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
}