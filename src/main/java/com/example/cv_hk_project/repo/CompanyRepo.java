package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository< Company ,Long> {
}
