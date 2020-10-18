package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;


import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;

import javax.persistence.*;

@Entity
@Table(name = "followed_profiles")
public class FollowedProfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followed_profile_id")
    private long id;
    @OneToOne(targetEntity = ProfileEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "followed_id", nullable = false)
    private ProfileEntity followedId;
    @OneToOne(targetEntity = ProfileEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "follower_id", nullable = false)
    private ProfileEntity followerId;

    public FollowedProfilesEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProfileEntity getFollowedId() {
        return followedId;
    }

    public void setFollowedId(ProfileEntity followedId) {
        this.followedId = followedId;
    }

    public ProfileEntity getFollowerId() {
        return followerId;
    }

    public void setFollowerId(ProfileEntity followerId) {
        this.followerId = followerId;
    }
}
