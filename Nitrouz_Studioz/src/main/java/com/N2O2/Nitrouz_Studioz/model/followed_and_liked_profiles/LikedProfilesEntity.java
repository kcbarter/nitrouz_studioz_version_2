package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;

import javax.persistence.*;

@Entity
@Table(name = "liked_profiles")
public class LikedProfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liked_profile_id")
    private long id;
    @OneToOne(targetEntity = ProfileEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "liked_id", nullable = false)
    private ProfileEntity likedId;
    @OneToOne(targetEntity = ProfileEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "liker_id", nullable = false)
    private ProfileEntity likerId;

    public LikedProfilesEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProfileEntity getLikedId() {
        return likedId;
    }

    public void setLikedId(ProfileEntity likedId) {
        this.likedId = likedId;
    }

    public ProfileEntity getLikerId() {
        return likerId;
    }

    public void setLikerId(ProfileEntity likerId) {
        this.likerId = likerId;
    }
}
