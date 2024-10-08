package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByContinentId(Long continentId);
    List<Country> findByContinentIdIn(List<Long> continentIds);
}
