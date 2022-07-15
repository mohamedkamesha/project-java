package com.example.cv_hk_project.mapper;

import com.example.cv_hk_project.DTO.AccountApplicant;
import com.example.cv_hk_project.DTO.AccountCompany;
import com.example.cv_hk_project.DTO.UserApplicantDTO;
import com.example.cv_hk_project.DTO.UserCompanyDTO;
import com.example.cv_hk_project.enumclass.Gender;
import com.example.cv_hk_project.enumclass.MilitaryStatus;
import com.example.cv_hk_project.enumclass.Type;
import com.example.cv_hk_project.model.Applicant;
import com.example.cv_hk_project.model.Company;
import com.example.cv_hk_project.model.User;

public class  UserMapper {

  public static AccountApplicant UserApplicantDTOToAccountApplicant(UserApplicantDTO userApplicantDTO){
    Type type = Type.valueOf(userApplicantDTO.getType());
    Gender gender = Gender.valueOf(userApplicantDTO.getGender());
    MilitaryStatus militaryStatus = MilitaryStatus.valueOf(userApplicantDTO.getMilitaryStatus());
    User user = new User(
            userApplicantDTO.getName(),userApplicantDTO.getEmail(), userApplicantDTO.getPassword(),
             type,userApplicantDTO.getImage(),userApplicantDTO.getFacebookLink(),
            userApplicantDTO.getGithubLink(), userApplicantDTO.getLinkedInLink());

    Applicant applicant = new Applicant(
            userApplicantDTO.getAddress(),userApplicantDTO.getBirthday(), userApplicantDTO.getPosition(),
            userApplicantDTO.getPhone(),userApplicantDTO.getExperience(),userApplicantDTO.getEducationLevel(),
             gender,userApplicantDTO.getAbout(),militaryStatus);


    user.setApplicant(applicant);
    user.setCompany(null);

    applicant.setUser1(user);

    AccountApplicant accountApplicant = new AccountApplicant(user,applicant) ;

    return accountApplicant;
  }


  public static AccountCompany UserCompanyDTOToAccountCompany(UserCompanyDTO userCompanyDTO){
    Type type = Type.valueOf(userCompanyDTO.getType());
    User user = new User(userCompanyDTO.getName(), userCompanyDTO.getEmail(), userCompanyDTO.getPassword(),
            type, userCompanyDTO.getImage(), userCompanyDTO.getFacebookLink(), userCompanyDTO.getGithubLink(), userCompanyDTO.getLinkedInLink());


    Company company = new Company(
            userCompanyDTO.getLocation(), userCompanyDTO.getCompanySize(),userCompanyDTO.getAbout(),
            userCompanyDTO.getFounded(), userCompanyDTO.getIndustry(), userCompanyDTO.getWebsites() );

    user.setApplicant(null);
    user.setCompany(company);

    company.setUser2(user);
    AccountCompany accountCompany = new AccountCompany(user,company);
    return accountCompany;
  }




}
