package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public Image uploadImage (MultipartFile file) ;
}
