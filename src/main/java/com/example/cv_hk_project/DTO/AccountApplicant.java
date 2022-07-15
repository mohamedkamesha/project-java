package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.model.Applicant;
import com.example.cv_hk_project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountApplicant {

    private User user;
    private Applicant applicant;

}
