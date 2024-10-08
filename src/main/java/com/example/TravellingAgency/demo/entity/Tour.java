package com.example.TravellingAgency.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int id;

    private String name;
    private String imgURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City fromCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_airport_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Airport fromAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City toCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_airport_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Airport toAirport;

    private LocalDate departureDate;
    private LocalDate dateOfReturn;
    private int numberOfDays;
    private String cityCountry;

    @Enumerated(EnumType.STRING)
    private TourType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionStatus promoted = PromotionStatus.NO;  // Default value

    private double discountPercentage = 0.0;
    private double priceOfTour;

    @Column(name = "original_price_of_tour")
    private double originalPriceOfTour;

    private int numberOfSeats;

    public void setPromoted(PromotionStatus promoted) {
        this.promoted = Objects.requireNonNullElse(promoted, PromotionStatus.NO);
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    // Ensure original prices are set when prices are initially set
    public void setPriceOfTour(double priceOfTour) {
        if (this.originalPriceOfTour == 0) {
            this.originalPriceOfTour = priceOfTour;
        }
        this.priceOfTour = priceOfTour;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;
}
