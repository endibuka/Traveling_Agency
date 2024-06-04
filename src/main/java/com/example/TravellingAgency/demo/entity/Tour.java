package com.example.TravellingAgency.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private City toCity;

    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private Airport toAirport;

    private LocalDate departureDate;
    private LocalDate dateOfReturn;
    private int numberOfDays;

    @Enumerated(EnumType.STRING)
    private TourType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionStatus promoted = PromotionStatus.NO;  // Default value

    private double discountPercentage = 0.0;

    private double priceForAdult;

    @Column(name = "original_price_for_adult")
    private double originalPriceForAdult;

    private int numberOfAdultSeats;

    public void setPromoted(PromotionStatus promoted) {
        if (promoted == null) {
            this.promoted = PromotionStatus.NO;  // Default to NO if null is provided
        } else {
            this.promoted = promoted;
        }
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    // Ensure original prices are set when prices are initially set
    public void setPriceForAdult(double priceForAdult) {
        if (this.originalPriceForAdult == 0) {
            this.originalPriceForAdult = priceForAdult;
        }
        this.priceForAdult = priceForAdult;
    }

}
