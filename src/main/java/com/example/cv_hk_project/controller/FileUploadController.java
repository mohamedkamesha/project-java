package com.example.cv_hk_project.controller;


import com.example.cv_hk_project.services.UploadFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private final UploadFileService uploadFileService;

    public FileUploadController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }


    @PostMapping("/upload/{id}")
    public String uploadFile(@PathVariable Long id , @RequestParam("file")MultipartFile file){
        return uploadFileService.uploadFile(id, file);
    }

}
