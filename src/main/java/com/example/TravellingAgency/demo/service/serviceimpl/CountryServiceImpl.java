package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.City;
import com.example.TravellingAgency.demo.entity.Country;
import com.example.TravellingAgency.demo.repository.CountryRepository;
import com.example.TravellingAgency.demo.repository.CityRepository;
import com.example.TravellingAgency.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {



    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<City> findByCountryIds(List<Long> countryIds) {
        return cityRepository.findByCountryIdIn(countryIds);
    }

    @Override
    public List<Country> findByContinentIds(List<Long> continentIds) {
        return countryRepository.findByContinentIdIn(continentIds);
    }

}