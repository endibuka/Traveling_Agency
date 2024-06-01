package com.example.TravellingAgency.demo.repositories;

import com.example.TravellingAgency.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}

