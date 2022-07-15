package com.example.cv_hk_project.services.impl;

import com.auth0.jwt.JWT;
import com.example.cv_hk_project.entity.CVHKUserDetails;
import com.example.cv_hk_project.util.JwtProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Service
public class TokenService {

    public String generateToken(Authentication authResult) {
        CVHKUserDetails userDetails = (CVHKUserDetails) authResult.getPrincipal();

        // Create JWT Token
        String token = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        return token;
    }
}
