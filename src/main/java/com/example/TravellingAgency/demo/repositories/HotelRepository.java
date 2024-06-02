package com.example.TravellingAgency.demo.repositories;// HotelRepository.java

import com.example.TravellingAgency.demo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

