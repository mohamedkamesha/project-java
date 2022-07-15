package com.example.cv_hk_project.mapper;

import com.example.cv_hk_project.DTO.ApplicantPostDTO;
import com.example.cv_hk_project.enumclass.JobTime;
import com.example.cv_hk_project.model.ApplicantPost;

import java.time.LocalDate;

public class PostMapper {
    public static ApplicantPost ApplicantPostDTOToApplicantPost(ApplicantPostDTO applicantPostDTO){
        System.out.println(applicantPostDTO);
        ApplicantPost applicantPost = new ApplicantPost();
        applicantPost.setJobName(applicantPostDTO.getJobName());
        applicantPost.setDescription(applicantPost.getDescription());
        applicantPost.setJobTime(JobTime.valueOf(applicantPostDTO.getJobTime()));
        applicantPost.setExperience(applicantPostDTO.getExperience());
        applicantPost.setDateCreation(LocalDate.now());



        return applicantPost;
    }
}
