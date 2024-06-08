package com.example.TravellingAgency.demo.service;

import com.example.TravellingAgency.demo.entity.Pictures;
import com.example.TravellingAgency.demo.repository.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PicturesService {

    @Autowired
    private PicturesRepository pictureRepository;

    public Pictures savePicture(MultipartFile file, String name) throws IOException {
        Pictures picture = new Pictures();
        picture.setName(name);
        picture.setImage(file.getBytes());
        return pictureRepository.save(picture);
    }

    public Optional<Pictures> getPicture(Long id) {
        return pictureRepository.findById(id);
    }
}
