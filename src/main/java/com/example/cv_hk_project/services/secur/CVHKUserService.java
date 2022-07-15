package com.example.cv_hk_project.services.secur;

import com.example.cv_hk_project.entity.CVHKUserDetails;
import com.example.cv_hk_project.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CVHKUserService implements UserDetailsService {

    private final UserRepo userRepo;

    public CVHKUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo
                .findByEmail(username)
                .map(CVHKUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
