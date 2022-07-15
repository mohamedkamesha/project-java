package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.ApplicantPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantPostRepo extends JpaRepository<ApplicantPost , Long> {
}
