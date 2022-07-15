package com.example.cv_hk_project.services.impl;

import com.example.cv_hk_project.DTO.*;
import com.example.cv_hk_project.exception.HandlerError;
import com.example.cv_hk_project.mapper.UserMapper;
import com.example.cv_hk_project.model.Role;
import com.example.cv_hk_project.model.User;
import com.example.cv_hk_project.repo.ApplicantRepo;
import com.example.cv_hk_project.repo.CompanyRepo;
import com.example.cv_hk_project.repo.RoleRepo;
import com.example.cv_hk_project.repo.UserRepo;
import com.example.cv_hk_project.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    final private UserRepo userRepo;
    final private ApplicantRepo applicantRepo;
    final private RoleRepo roleRepo;
    final private CompanyRepo companyRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;




    public UserServiceImpl(UserRepo userRepo, ApplicantRepo applicantRepo, RoleRepo roleRepo, CompanyRepo companyRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepo = userRepo;
        this.applicantRepo = applicantRepo;
        this.roleRepo = roleRepo;
        this.companyRepo = companyRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @Override
    @Transactional
    public String registerUserCompany(UserCompanyDTO userCompanyDTO) {
        AccountCompany accountCompany = UserMapper.UserCompanyDTOToAccountCompany(userCompanyDTO);

        if( userRepo.existsByEmail(accountCompany.getUser().getEmail()) ){
            throw new HandlerError("this email or user name already founded");
        }
        User user = accountCompany.getUser();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setEnable(true);

        System.out.println(user);
        System.out.println(accountCompany.getCompany());

        userRepo.save(accountCompany.getUser());
        companyRepo.save(accountCompany.getCompany());


        return "account save";
    }

    @Override
    @Transactional
    public String registerUserApplicant(UserApplicantDTO userApplicantDTO) {
        AccountApplicant accountApplicant = UserMapper.UserApplicantDTOToAccountApplicant(userApplicantDTO);
        if( userRepo.existsByEmail(accountApplicant.getUser().getEmail()) ){
            throw new HandlerError("this email or user name already founded");
        }

        User user = accountApplicant.getUser();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setEnable(true);
        Role role = new Role();
        role.setRole("user");
        user.getRoles().add(role);


        roleRepo.save(role);
        userRepo.save(user);
        applicantRepo.save(accountApplicant.getApplicant());

        return "account save";
    }

    @Override
    public LoginDTO login(String email, String password) {

        if( !userRepo.existsByEmail( email )){
            throw new HandlerError("this email or user name already founded");
        }
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = tokenService.generateToken(authenticate);
        User user = userRepo.findByEmail(email).orElseThrow(() -> new HandlerError("User not found" ));
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setToken(token);
        loginDTO.setType(user.getType().toString());
        loginDTO.setEmail(user.getEmail());
        loginDTO.setImage(user.getImage());
        loginDTO.setName(user.getName());

        return loginDTO;
    }

}
