package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.Uzer;
import com.example.TravellingAgency.demo.repository.UzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UzerController {

    @Autowired
    private UzerRepository uzerRepository;

    // Create
    @PostMapping
    public Uzer createUser(@RequestBody Uzer uzer) {
        return uzerRepository.save(uzer);
    }

    // Read all
    @GetMapping
    public List<Uzer> getAllUsers() {
        return uzerRepository.findAll();
    }

    // Read by id
    @GetMapping("/{id}")
    public Uzer getUserById(@PathVariable Long id) {
        return uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Update
    @PutMapping("/{id}")
    public Uzer updateUser(@PathVariable Long id, @RequestBody Uzer updatedUzer) {
        Uzer uzer = uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        uzer.setFirstName(updatedUzer.getFirstName());
        uzer.setLastName(updatedUzer.getLastName());
        uzer.setEmail(updatedUzer.getEmail());
        uzer.setPassword(updatedUzer.getPassword());
        // Set other fields accordingly
        return uzerRepository.save(uzer);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Uzer uzer = uzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        uzerRepository.delete(uzer);
        return "User deleted successfully";
    }
}
