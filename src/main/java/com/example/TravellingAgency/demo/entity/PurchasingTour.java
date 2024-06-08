package com.example.TravellingAgency.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchasingTour")
public class PurchasingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchasing_tour_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uzer_id")
    private Uzer uzer;

}
