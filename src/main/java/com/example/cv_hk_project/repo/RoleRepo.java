package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleRepo extends JpaRepository<Role,Long> {
}
