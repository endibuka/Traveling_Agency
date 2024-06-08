package com.example.TravellingAgency.demo.controller;

import com.example.TravellingAgency.demo.entity.Pictures;
import com.example.TravellingAgency.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/pictures")
public class PicturesController { // Renamed to PicturesController

    @Autowired
    private PicturesService pictureService;

    @PostMapping("/upload")
    public ResponseEntity<Pictures> uploadPicture(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        try {
            Pictures savedPicture = pictureService.savePicture(file, name);
            return new ResponseEntity<>(savedPicture, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPicture(@PathVariable Long id) {
        Optional<Pictures> picture = pictureService.getPicture(id);
        if (picture.isPresent()) {
            return ResponseEntity.ok().body(picture.get().getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
