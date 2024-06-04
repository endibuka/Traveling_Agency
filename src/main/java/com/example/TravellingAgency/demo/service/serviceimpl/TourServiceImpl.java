package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.PromotionStatus;
import com.example.TravellingAgency.demo.entity.Tour;
import com.example.TravellingAgency.demo.repository.TourRepository;
import com.example.TravellingAgency.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> findById(int id) {
        return tourRepository.findById(id);
    }

    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public void deleteById(int id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Tour updatePromotion(int tourId, PromotionStatus promotionStatus, Double discountPercentage) {
        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        tour.setPromoted(promotionStatus);

        if (promotionStatus == PromotionStatus.YES) {
            if (discountPercentage == null || discountPercentage < 0 || discountPercentage > 100) {
                throw new IllegalArgumentException("Invalid discount percentage");
            }
            // Set the discount percentage
            tour.setDiscountPercentage(discountPercentage);

            // Apply the discount to the prices
            double discountFactor = 1 - (discountPercentage / 100.0);
            tour.setPriceForAdult(tour.getOriginalPriceForAdult() * discountFactor);
            tour.setPriceForChild(tour.getOriginalPriceForChild() * discountFactor);

        } else {
            // If not promoted, reset the discount percentage to 0 and restore original prices
            tour.setDiscountPercentage(0.0);
            tour.setPriceForAdult(tour.getOriginalPriceForAdult());
            tour.setPriceForChild(tour.getOriginalPriceForChild());
        }

        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> findByFromCity(City fromCity) {
        return tourRepository.findByFromCity(fromCity);
    }

    @Override
    public List<Tour> findByToCity(City toCity) {
        return tourRepository.findByToCity(toCity);
    }

    @Override
    public List<Tour> findByFromCityAndToCity(City fromCity, City toCity) {
        return tourRepository.findByFromCityAndToCity(fromCity, toCity);
    }
}
