package com.example.cv_hk_project.repo;

import com.example.cv_hk_project.enumclass.Type;
import com.example.cv_hk_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository< User,Long> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    List<User> findByTypeAndApplicantPosition(Type type , String position);




}
