package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Continent;
import com.example.TravellingAgency.demo.entity.User;
import com.example.TravellingAgency.demo.repositories.ContinentRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public Continent createContinent(Continent continent){
        return continentRepository.save(continent);
    }

}
