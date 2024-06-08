package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.Continent;
import com.example.TravellingAgency.demo.entity.Country;
import com.example.TravellingAgency.demo.repository.ContinentRepository;
import com.example.TravellingAgency.demo.repository.CountryRepository;
import com.example.TravellingAgency.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Continent> findAll() {
        return continentRepository.findAll();
    }

    @Override
    public Optional<Continent> findById(Long id) {
        return continentRepository.findById(id);
    }

    @Override
    public Continent save(Continent continent) {
        return continentRepository.save(continent);
    }

    @Override
    public void deleteById(Long id) {
        continentRepository.deleteById(id);
    }

    @Override
    public List<Country> findByCountryIds(List<Long> continentIds) {
        return countryRepository.findByContinentIdIn(continentIds);
    }
}