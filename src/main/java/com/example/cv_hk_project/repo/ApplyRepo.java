package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepo extends JpaRepository< Apply , Long> {

    List<Apply> findByCompanyJobIdAndCvRankNotNullOrderByCvRankDesc(Long id);
}
