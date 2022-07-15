package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.ApplicantWorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantWorkExperienceRepo extends JpaRepository< ApplicantWorkExperience ,Long > {
}
