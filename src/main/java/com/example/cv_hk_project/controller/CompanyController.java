package com.example.cv_hk_project.controller;

import com.example.cv_hk_project.DTO.CompanyJobDTO;
import com.example.cv_hk_project.model.Apply;
import com.example.cv_hk_project.model.CompanyJob;
import com.example.cv_hk_project.model.User;
import com.example.cv_hk_project.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/add_job")
    public String addJob(@RequestBody CompanyJobDTO companyJobDTO){

        System.out.println(companyJobDTO.toString());
        return companyService.addCompanyJob(companyJobDTO) ;
    }

    @GetMapping("/search_applicant/{position}")
    public List<User> findUser(@PathVariable String position){

        // return dto
        return companyService.findUser(position);
    }

    @GetMapping("/cvs/{id}")
    public List<Apply> findFilterCvs(@PathVariable Long id){
        return companyService.findFilterCvs(id) ;
    }

    @GetMapping("/get_my_jobs")
    public  List<CompanyJob> findMyJobs (){
        return companyService.findMyJobs();
    }



}
