package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository< Applicant,Long> {
}
