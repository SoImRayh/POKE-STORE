package dev.rayh.cardstore.service.imp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.rayh.cardstore.service.FileStorageService;

@Service
public class FileStorageServiceImp implements FileStorageService {

    private final Path ROOT_DEFAULT = Path.of("./cards");

    @Override
    public String storeFile(MultipartFile file) {
        try {
            if (!Files.exists(ROOT_DEFAULT)) {
                Files.createDirectory(ROOT_DEFAULT);
                System.out.println("Directory created: " + ROOT_DEFAULT.toAbsolutePath());
            }


            String originalFilename = file.getOriginalFilename();
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String uniqueFilename = UUID.randomUUID().toString() + extension;
            
            Path destinationFile = this.ROOT_DEFAULT.resolve(
                    Paths.get(uniqueFilename))
                    .normalize();

            // Save the file to the filesystem
            try (var inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile);
            }
                return uniqueFilename;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
