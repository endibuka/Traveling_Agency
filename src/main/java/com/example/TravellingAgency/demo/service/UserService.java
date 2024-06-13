package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.User;
import java.util.Optional;

public interface UserService {
    User updateUser(Long id, User updatedUser);

    void registerUser(User user);

    Optional<User> findUserByEmail(String email);

    Optional<User> loginUser(String email, String password);

    Optional<User> findUserById(Long id);

}