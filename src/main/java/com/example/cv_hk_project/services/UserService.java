package com.example.cv_hk_project.services;

import com.example.cv_hk_project.DTO.LoginDTO;
import com.example.cv_hk_project.DTO.UserApplicantDTO;
import com.example.cv_hk_project.DTO.UserCompanyDTO;

public interface UserService {
    String registerUserCompany (UserCompanyDTO userCompanyDTO);
    String registerUserApplicant(UserApplicantDTO userApplicantDTO);
    LoginDTO login(String email, String password);
}
