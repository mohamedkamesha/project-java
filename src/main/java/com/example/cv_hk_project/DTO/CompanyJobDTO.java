package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.enumclass.JobTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyJobDTO {


    private String jobName;
    private String jobTime;
    private String experience;
    private List<String> requirements;
    private String description;


}
