package com.example.cv_hk_project.model;

import com.example.cv_hk_project.enumclass.JobTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id ;
    private String jobName;
    private JobTime jobTime;
    private String experience;
    private LocalDate dateCreation;
    @Column(columnDefinition="TEXT")
    private String description;
    private String cvName;

    @ManyToOne
    @JsonIgnore
    private Applicant applicant;
}
