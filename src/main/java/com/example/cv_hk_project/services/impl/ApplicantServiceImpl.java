package com.example.cv_hk_project.services.impl;

import com.example.cv_hk_project.DTO.ApplicantPostDTO;
import com.example.cv_hk_project.enumclass.Type;
import com.example.cv_hk_project.exception.HandlerError;
import com.example.cv_hk_project.mapper.PostMapper;
import com.example.cv_hk_project.model.Applicant;
import com.example.cv_hk_project.model.ApplicantPost;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.User;
import com.example.cv_hk_project.repo.ApplicantPostRepo;
import com.example.cv_hk_project.repo.ApplicantRepo;
import com.example.cv_hk_project.repo.CompanyJobRepo;
import com.example.cv_hk_project.repo.UserRepo;
import com.example.cv_hk_project.services.ApplicantService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final CompanyJobRepo companyJobRepo;
    private final UserRepo userRepo;
    private final ApplicantRepo applicantRepo;
    private final ApplicantPostRepo applicantPostRepo;

    public ApplicantServiceImpl(CompanyJobRepo companyJobRepo, UserRepo userRepo, ApplicantRepo applicantRepo, ApplicantPostRepo applicantPostRepo) {
        this.companyJobRepo = companyJobRepo;
        this.userRepo = userRepo;
        this.applicantRepo = applicantRepo;
        this.applicantPostRepo = applicantPostRepo;
    }


    @Override
    public List<CompanyJob> findJob(String position) {
        System.out.println(position);
        return companyJobRepo.findByJobNameContains(position);
    }

    @Override
    public String addPost(ApplicantPostDTO applicantPostDTO) {
        ApplicantPost applicantPost = PostMapper.ApplicantPostDTOToApplicantPost(applicantPostDTO);
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(userEmail).orElseThrow(() -> new HandlerError("User not found" ));
        if(user.getType() == Type.applicant){
            Applicant applicant = user.getApplicant();
            applicant.getApplicantPosts().add(applicantPost);
            applicantPost.setApplicant(applicant);

            applicantPostRepo.save(applicantPost);
            applicantRepo.save(applicant);

        }else throw new HandlerError("not applicant ");

        return "post add";
    }

    @Override
    public List<CompanyJob> findAllJobs() {
        return companyJobRepo.findAll();
    }
}
