package com.example.cv_hk_project.services;

import com.example.cv_hk_project.DTO.CompanyJobDTO;
import com.example.cv_hk_project.model.Apply;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.User;

import java.util.List;

public interface CompanyService {
    List<Apply> findFilterCvs(Long id);
    String addCompanyJob (CompanyJobDTO companyJobDTO);
    List<User> findUser (String position);
    List<CompanyJob> findMyJobs();
}
