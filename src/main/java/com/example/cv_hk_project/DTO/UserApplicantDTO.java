package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.enumclass.Gender;
import com.example.cv_hk_project.enumclass.MilitaryStatus;
import com.example.cv_hk_project.enumclass.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicantDTO {

    private String name;
    private String email;
    private String password;
    private String type;
    private String image;
    private String facebookLink;
    private String githubLink;
    private String LinkedInLink;

    private String address;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
    private String position;
    private String phone;
    private String experience;
    private String educationLevel;
    private String gender = Gender.Male.toString();
    private String about;
    private String militaryStatus = MilitaryStatus.NotApplicable.toString();



}
