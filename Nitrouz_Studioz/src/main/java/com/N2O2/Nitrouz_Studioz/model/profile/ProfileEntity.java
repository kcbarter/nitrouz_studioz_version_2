package com.N2O2.Nitrouz_Studioz.model.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileID")
    private Long id;
    @Column(name = "profile_pic")
    private String profilePic;
    @Column(name = "profile_name")
    private String profileName;
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(min=3)
    @Column(name = "email")
    private String email;
    @Column(name = "about")
    private String about;
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Size(min=8)
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
    @Column(name = "enabled")
    private boolean enabled;

    public ProfileEntity(String profilePic, String profileName, String name, String email, String about, String phone,
        String password, boolean likes, boolean comments, boolean follows, boolean general, boolean enabled){
        this.profilePic = profilePic;
        this.profileName = profileName;
        this.name = name;
        this.email = email;
        this.about = about;
        this.phone = phone;
        this.password = password;
        this.likes = likes;
        this.comments = comments;
        this.follows = follows;
        this.general = general;
        this.enabled = enabled;
    }

    public ProfileEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public boolean isComments() {
        return comments;
    }

    public void setComments(boolean comments) {
        this.comments = comments;
    }

    public boolean isFollows() {
        return follows;
    }

    public void setFollows(boolean follows) {
        this.follows = follows;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
