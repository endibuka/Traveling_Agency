package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.entity.Uzer;
import com.example.TravellingAgency.demo.repository.UzerRepository;
import com.example.TravellingAgency.demo.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzerServiceImpl implements UzerService {

    @Autowired
    private UzerRepository uzerRepository;

    @Override
    public Uzer createUser(Uzer uzer) {
        return uzerRepository.save(uzer);
    }

    @Override
    public List<Uzer> getAllUsers() {
        return uzerRepository.findAll();
    }

    @Override
    public Uzer getUserById(Long id) {
        return uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Uzer updateUser(Long id, Uzer updatedUzer) {
        Uzer uzer = uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        uzer.setFirstName(updatedUzer.getFirstName());
        uzer.setLastName(updatedUzer.getLastName());
        uzer.setEmail(updatedUzer.getEmail());
        uzer.setPassword(updatedUzer.getPassword());
        // Set other fields accordingly
        return uzerRepository.save(uzer);
    }

    @Override
    public void deleteUser(Long id) {
        Uzer uzer = uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        uzerRepository.delete(uzer);
    }
}