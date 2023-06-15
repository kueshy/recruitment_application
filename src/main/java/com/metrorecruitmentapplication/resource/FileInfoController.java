package com.metrorecruitmentapplication.resource;

import com.metrorecruitmentapplication.domain.UploadResponse;
import com.metrorecruitmentapplication.service.FileInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class FileInfoController {

    private final FileInfoService fileInfoService;

    private FileInfoController(FileInfoService fileInfoService){
        this.fileInfoService = fileInfoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadFile(@RequestParam(name = "file", required = false)MultipartFile file){
        String fileName = fileInfoService.storeFile(file);
        UploadResponse uploadResponse = new UploadResponse(fileName);
        return ResponseEntity.ok().body(uploadResponse);
    }
}
