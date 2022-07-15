package com.example.cv_hk_project.controller;

import com.example.cv_hk_project.DTO.ApplicantPostDTO;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.services.ApplicantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }


    @GetMapping("/find_jobs/{position}")
    public List<CompanyJob> findJob(@PathVariable String position){

        // return DTO
        return applicantService.findJob(position);
    }

    @GetMapping("find_all_jobs")
    public List<CompanyJob> findAllJobs (){
        return applicantService.findAllJobs();
    }

    @PostMapping("/add_post")
    public String addPost(@RequestBody ApplicantPostDTO applicantPostDTO){

        return applicantService.addPost(applicantPostDTO);

    }




}
