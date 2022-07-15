package com.example.cv_hk_project.services.impl;

import com.example.cv_hk_project.DTO.CompanyJobDTO;
import com.example.cv_hk_project.enumclass.Type;
import com.example.cv_hk_project.exception.HandlerError;
import com.example.cv_hk_project.mapper.CompanyMapper;
import com.example.cv_hk_project.model.Apply;
import com.example.cv_hk_project.model.Company;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.User;
import com.example.cv_hk_project.repo.*;
import com.example.cv_hk_project.services.CompanyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;
    private final JobRequirementRepo jobRequirementRepo;
    private final CompanyJobRepo companyJobRepo;
    private final UserRepo userRepo;
    private final ApplyRepo applyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo, JobRequirementRepo jobRequirementRepo, CompanyJobRepo companyJobRepo, UserRepo userRepo, ApplyRepo applyRepo) {
        this.companyRepo = companyRepo;
        this.jobRequirementRepo = jobRequirementRepo;
        this.companyJobRepo = companyJobRepo;
        this.userRepo = userRepo;
        this.applyRepo = applyRepo;
    }


    @Override
    public List<Apply> findFilterCvs(Long id) {

        return applyRepo.findByCompanyJobIdAndCvRankNotNullOrderByCvRankDesc(id);
    }

    @Override
    public String addCompanyJob(CompanyJobDTO companyJobDTO) {


        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(userEmail).orElseThrow(() -> new HandlerError("User not found" ));
        Company company = user.getCompany();
        if(company == null){
            throw new HandlerError("user not founded");
        }



        CompanyJob companyJob = CompanyMapper.companyJobDTOToCompanyJob(companyJobDTO);
        company.getCompanyJobs().add(companyJob);
        companyJob.setCompany(company);
        // System.out.println(companyJob.toString());

        companyJobRepo.save(companyJob);
        companyRepo.save(company);
        jobRequirementRepo.saveAll(companyJob.getJobRequirements());




        return "okkk";
    }

    @Override
    public List<User> findUser(String position) {
       return  userRepo.findByTypeAndApplicantPosition(Type.applicant,position);
    }

    @Override
    public List<CompanyJob> findMyJobs() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(userEmail).orElseThrow(() -> new HandlerError("User not found" ));
        List<CompanyJob> companyJobs = null;
        if(user.getType() == Type.company){
            companyJobs = user.getCompany().getCompanyJobs();
        }
        return companyJobs;
    }
}
