package com.example.cv_hk_project.controller;

import com.example.cv_hk_project.DTO.LoginDTO;
import com.example.cv_hk_project.DTO.UserApplicantDTO;
import com.example.cv_hk_project.DTO.UserCompanyDTO;
import com.example.cv_hk_project.entity.LoginRequest;
import com.example.cv_hk_project.entity.LoginResponse;
import com.example.cv_hk_project.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/company_register")
    public String companyRegister(@RequestBody UserCompanyDTO userCompanyDTO){

        return userService.registerUserCompany(userCompanyDTO) ;
    }

    @PostMapping("/applicant_register")
    public String applicantRegister(@RequestBody UserApplicantDTO userApplicantDTO){

        return userService.registerUserApplicant(userApplicantDTO);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login( @RequestBody LoginRequest loginRequest) {


        System.out.println("fdfdfdfdfd");
        LoginDTO loginDTO = userService.login(loginRequest.getEmail(), loginRequest.getPassword());



        return ResponseEntity
                .ok()
                .body(new LoginResponse(
                        loginDTO.getToken(),
                        loginDTO.getType(),
                        loginDTO.getEmail(),
                        loginDTO.getImage(),
                        loginDTO.getName()));
    }



}
