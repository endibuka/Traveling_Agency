package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.PromotionStatus;
import com.example.TravellingAgency.demo.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> findAll();
    Optional<Tour> findById(int id);
    Tour save(Tour tour);
    void deleteById(int id);
    Tour updatePromotion(int tourId, PromotionStatus promotionStatus, Double discountPercentage);
    List<Tour> findByFromCity(City fromCity);
    List<Tour> findByToCity(City toCity);
    List<Tour> findByFromCityAndToCity(City fromCity, City toCity);
    List<Tour> findAllByOrderByPriceAsc();

    List<Tour> findAllByOrderByPriceDesc();

    Double calculateTotalPrice(List<Integer> tourIds);


}
