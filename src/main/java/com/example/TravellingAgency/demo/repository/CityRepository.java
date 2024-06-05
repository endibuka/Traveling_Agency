package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCountryId(Long countryId);
    List<City> findByCountryIdIn(List<Long> countryIds);
}