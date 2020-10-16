package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;


import javax.persistence.*;

@Entity
@Table(name = "followed_profiles")
public class FollowedProfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followed _profile_id")
    private long id;

}
