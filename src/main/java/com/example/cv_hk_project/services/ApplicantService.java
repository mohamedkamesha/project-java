package com.example.cv_hk_project.services;

import com.example.cv_hk_project.DTO.ApplicantPostDTO;
import com.example.cv_hk_project.model.CompanyJob;

import java.util.List;

public interface ApplicantService {

    List<CompanyJob> findJob(String position);

    String addPost(ApplicantPostDTO applicantPostDTO);

    List<CompanyJob> findAllJobs();
}
