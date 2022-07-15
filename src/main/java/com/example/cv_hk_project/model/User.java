package com.example.cv_hk_project.model;

import com.example.cv_hk_project.enumclass.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

   public User(String name, String email, String password, Type type, String image, String facebookLink, String githubLink, String linkedInLink) {
      this.name = name;
      this.email = email;
      this.password = password;
      this.type = type;
      this.image = image;
      this.facebookLink = facebookLink;
      this.githubLink = githubLink;
      LinkedInLink = linkedInLink;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;
   private String name;
   private String email;
   private String password;
   private Type type;
   private String image;
   private String facebookLink;
   private String githubLink;
   private String LinkedInLink;

   private Boolean enable;
   private Boolean accountNonExpired;
   private Boolean credentialsNonExpired;
   private Boolean accountNonLocked;



   @OneToOne(mappedBy = "user2")
   @JsonIgnore
   private Company company;

   @OneToOne(mappedBy = "user1")
   @JsonIgnore
   private Applicant applicant;

   @OneToMany(mappedBy = "user")
   @JsonIgnore
   private List<Role> roles = new ArrayList<>();


}
