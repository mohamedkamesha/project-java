package com.example.cv_hk_project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @JsonProperty("user_token")
    private String userToken;

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("email")
    private String email;

    @JsonProperty("image")
    private String image;

    @JsonProperty("name")
    private String name;



}
