package com.example.TravellingAgency.demo.service;

package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }
}
