package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
