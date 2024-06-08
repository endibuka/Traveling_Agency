package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.PromotionStatus;
import com.example.TravellingAgency.demo.entity.Tour;
import com.example.TravellingAgency.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionScheduler {

    @Autowired
    private TourRepository tourRepository;

    @Scheduled(cron = "0 0 0 * * ?") // Runs daily at midnight
    public void updatePromotions() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        List<Tour> tours = tourRepository.findByDepartureDate(tomorrow);

        for (Tour tour : tours) {
            if (tour.getPromoted() == PromotionStatus.YES) {
                tour.setPromoted(PromotionStatus.NO);
                tour.setDiscountPercentage(0.0);
                // Reset the prices to the original values
                tour.setPriceOfTour(tour.getOriginalPriceOfTour());
                tourRepository.save(tour);
            }
        }
    }
}
