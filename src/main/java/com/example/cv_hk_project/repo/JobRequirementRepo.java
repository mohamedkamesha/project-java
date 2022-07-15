package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.JobRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequirementRepo extends JpaRepository<JobRequirement,Long > {
}
