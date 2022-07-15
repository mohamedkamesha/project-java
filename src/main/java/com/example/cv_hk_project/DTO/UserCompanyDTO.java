package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.enumclass.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCompanyDTO {

    private String name;
    private String email;
    private String password;
    private String type;
    private String founded;
    private String industry;
    private String websites;

    private String image;
    private String facebookLink;
    private String githubLink;
    private String LinkedInLink;

    private String location;
    private Long companySize;
    private String about;


}
