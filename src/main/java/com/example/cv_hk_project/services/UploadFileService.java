package com.example.cv_hk_project.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String uploadFile (Long id, MultipartFile multipartFile);
}
