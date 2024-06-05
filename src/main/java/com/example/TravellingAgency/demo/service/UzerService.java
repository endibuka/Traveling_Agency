package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Uzer;

import java.util.List;

public interface UzerService {

    Uzer createUser(Uzer uzer);

    List<Uzer> getAllUsers();

    Uzer getUserById(Long id);

    Uzer updateUser(Long id, Uzer updatedUzer);

    void deleteUser(Long id);
}
