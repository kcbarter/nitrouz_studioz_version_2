package com.N2O2.Nitrouz_Studioz.model.ProfileService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "profilePic")
    private String profilePic;
    @NotNull
    @Column(name = "profileName")
    private String profileName;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "about")
    private String about;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "likes")
    private boolean likes;
    @Column(name = "comments")
    private boolean comments;
    @Column(name = "follows")
    private boolean follows;
    @Column(name = "general")
    private boolean general;
}
