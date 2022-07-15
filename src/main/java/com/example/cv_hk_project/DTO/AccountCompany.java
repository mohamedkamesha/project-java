package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.model.Company;
import com.example.cv_hk_project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCompany {
    private User user;
    private Company company;

}
