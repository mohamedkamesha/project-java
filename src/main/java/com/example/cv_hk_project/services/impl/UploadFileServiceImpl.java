package com.example.cv_hk_project.services.impl;

import com.example.cv_hk_project.aws.UploadFile;
import com.example.cv_hk_project.enumclass.JopApplyStatus;
import com.example.cv_hk_project.enumclass.Type;
import com.example.cv_hk_project.exception.HandlerError;
import com.example.cv_hk_project.model.Applicant;
import com.example.cv_hk_project.model.Apply;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.User;
import com.example.cv_hk_project.random.RandomName;
import com.example.cv_hk_project.repo.ApplicantRepo;
import com.example.cv_hk_project.repo.ApplyRepo;
import com.example.cv_hk_project.repo.CompanyJobRepo;
import com.example.cv_hk_project.repo.UserRepo;
import com.example.cv_hk_project.services.UploadFileService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final UserRepo userRepo ;
    private final CompanyJobRepo companyJobRepo;
    private final ApplyRepo applyRepo;
    private final ApplicantRepo applicantRepo;

    public UploadFileServiceImpl(UserRepo userRepo, CompanyJobRepo companyJobRepo, ApplyRepo applyRepo, ApplicantRepo applicantRepo) {
        this.userRepo = userRepo;
        this.companyJobRepo = companyJobRepo;
        this.applyRepo = applyRepo;
        this.applicantRepo = applicantRepo;

    }


    @Override
    public String uploadFile(Long id, MultipartFile file) {


        if(file.isEmpty() || !(file.getContentType().equals("application/pdf")) ) {
             throw new HandlerError("file is empty");
        }

        String fileName = RandomName.generateRandomName(5);

        String message = null;
        try {
            message = UploadFile.upload(fileName, file.getInputStream());
    }catch (Exception e){
        throw new HandlerError(e.getMessage());
    }


            String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepo.findByEmail(userEmail).orElseThrow(() -> new HandlerError("User not found" ));


            Apply apply = new Apply();
            apply.setCvName("https://mycvfile.s3.amazonaws.com/"+fileName);
            apply.setJopApplyStatus(JopApplyStatus.InProgress);
            apply.setCvRank((int) Math.random()*100);


           CompanyJob companyJob = companyJobRepo.findById(id).orElseThrow(() -> new HandlerError("job not found" ));

        System.out.println(companyJob);
           companyJob.getCvs().add(apply);
           apply.setCompanyJob(companyJob);

            if(user.getType() == Type.applicant){
                Applicant applicant = user.getApplicant();
                applicant.getApplies().add(apply);
                apply.setApplicant(applicant);
                applyRepo.save(apply);
                applicantRepo.save(applicant);
                companyJobRepo.save(companyJob);
            }else {
                applyRepo.save(apply);
                companyJobRepo.save(companyJob);
            }










        return message ;
    }
}
