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
    private String type; // BB, HB, FB, AI
    private double priceForAdult;
    private double priceForChild;
    private boolean promoted;
    private int numberOfAdultSeats;
    private int numberOfPlacesForChildren;
}




