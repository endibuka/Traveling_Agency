package com.example.TravellingAgency.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private City fromCity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private City toCity;

    @JsonIgnore
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

    private double priceOfTour;

    @Column(name = "original_price_of_tour")
    private double originalPriceOfTour;

    private int numberOfSeats;

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
