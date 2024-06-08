package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByCityId(Long cityId);
    List<Airport> findByCityIdIn(List<Long> cityIds);
}