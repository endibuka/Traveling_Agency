package com.example.TravellingAgency.demo.service.serviceimpl;

import com.example.TravellingAgency.demo.config.UploadConfig;
import com.example.TravellingAgency.demo.entity.Image;
import com.example.TravellingAgency.demo.entity.ModelMapperUtils;
import com.example.TravellingAgency.demo.repository.ImageRepository;
import com.example.TravellingAgency.demo.service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    UploadConfig uploadConfig;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image uploadImage(MultipartFile file) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uniqueFileName = System.currentTimeMillis() + "_" + generateRandomFileName() + "." + fileExtension;

        File uploadDir = new File(uploadConfig.getUploadDirectory());
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            Path filePath = Path.of(uploadConfig.getUploadDirectory(), uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("e " + e);
            throw new RuntimeException();
        }

        Image image = new Image();
        image.setFileName(uniqueFileName);
        image.setOriginalFileName(originalFileName);
        String baseUrl = generateImageAbsolutePath();
        image.setUrl(baseUrl);
        imageRepository.save(image);
        return ModelMapperUtils.map(image, Image.class);
    }

    public String generateImageAbsolutePath() {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/images/")
                .toUriString();
    }

    public Image getImageById(String imageId) {
        return imageRepository.findById(Long.valueOf(imageId)).orElseThrow(EntityNotFoundException::new);
    }

    private String generateRandomFileName() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}


