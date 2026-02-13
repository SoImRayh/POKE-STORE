package dev.rayh.cardstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileStorageService {
    String storeFile(MultipartFile file);
}
