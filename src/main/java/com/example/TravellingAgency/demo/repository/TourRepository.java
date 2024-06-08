package com.example.TravellingAgency.demo.repository;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

    List<Tour> findByDepartureDate(LocalDate departureDate);
    List<Tour> findByFromCity(City fromCity);
    List<Tour> findByToCity(City toCity);
    List<Tour> findByFromCityAndToCity(City fromCity, City toCity);
    List<Tour> findAllByOrderByPriceOfTourAsc(double priceOfTour);
    List<Tour> findAllByOrderByPriceOfTourDesc(double priceOfTour);
}