package com.example.cv_hk_project.mapper;

import com.example.cv_hk_project.DTO.CompanyJobDTO;
import com.example.cv_hk_project.enumclass.JobTime;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.JobRequirement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyMapper {
    public static CompanyJob companyJobDTOToCompanyJob(CompanyJobDTO companyJobDTO){

        List<JobRequirement> jobRequirements = new ArrayList<>();
        CompanyJob companyJob = new CompanyJob(
                companyJobDTO.getJobName(), JobTime.valueOf(companyJobDTO.getJobTime()),
                companyJobDTO.getExperience(), LocalDate.now(), companyJobDTO.getDescription(),
                null);


        for(String requirement : companyJobDTO.getRequirements()){
            JobRequirement jobRequirement = new JobRequirement(requirement,companyJob);
            jobRequirements.add(jobRequirement);
        }

        companyJob.setJobRequirements(jobRequirements);



        return  companyJob;
    }

}
