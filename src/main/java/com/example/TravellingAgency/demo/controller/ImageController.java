package com.example.TravellingAgency.demo.controller;


import com.example.TravellingAgency.demo.entity.Image;
import com.example.TravellingAgency.demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")

public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("image") MultipartFile file) {
        Image imageEntity = imageService.uploadImage(file);
        return ResponseEntity.ok(imageEntity);
    }
}
