package com.metrorecruitmentapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Service
public class FileInfoService {
    private final Path fileStorageLocation;

    @Autowired
    public FileInfoService(Environment environment){
        this.fileStorageLocation = Paths.get(environment.getProperty("app.file.upload-dir", "./uploads/files"))
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception e){
            throw new RuntimeException("Could not create directory.");
        }
    }

    public String getFileExtension(String file_name){
        if(file_name==null){
            return null;
        }
        String[] fileNameParts = file_name.split("\\.");
        return fileNameParts[fileNameParts.length - 1];
    }

    public String storeFile(MultipartFile file){
        String fileName = new Date().getTime() + "-file."+getFileExtension(file.getOriginalFilename());
        try{
            if (fileName.contains("..")){
                throw new RuntimeException("File contains invalid characters");
            }
            Path targetLocation=this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (IOException e){
            throw new RuntimeException("Could not store filename"+fileName, e);
        }

    }
}
