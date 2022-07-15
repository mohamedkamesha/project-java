package com.example.cv_hk_project.DTO;

import com.example.cv_hk_project.enumclass.JobTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantPostDTO {

    private String jobName;
    private String experience;
    private String description;
    private String jobTime = JobTime.FullTime.toString() ;

    @Override
    public String toString() {
        return "ApplicantPostDTO{" +
                "jobName='" + jobName + '\'' +
                ", experience='" + experience + '\'' +
                ", description='" + description + '\'' +
                ", jobTime='" + jobTime + '\'' +
                '}';
    }
}
