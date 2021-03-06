package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.FollowedProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.FollowedProfilesEntity;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.LikedProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.LikedProfilesEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private ProfileDoa profileDoa;

    @Autowired
    private LikedProfileDoa likedProfileDoa;
    @Autowired
    private FollowedProfileDoa followedProfileDoa;
    private LikedProfilesEntity likedProfilesEntity;
    private FollowedProfilesEntity followedProfilesEntity;

    public List<ProfileEntity> getAllProfiles(){
        List<ProfileEntity> profiles;
        profiles = profileDoa.findAll();
        return profiles;
    }

    public List <ProfileEntity> getProfilesLikedByUser(ProfileEntity profile){
        List<ProfileEntity> likedProfiles;
        likedProfiles = likedProfileDoa.getByLikerId(profile);
        return likedProfiles;
    }

    public List <ProfileEntity> getProfilesFollowedByUser(ProfileEntity profile){
        List<ProfileEntity> followedProfiles;
        followedProfiles = followedProfileDoa.getByFollowerId(profile);
        return followedProfiles;
    }

    public void likeProfile(ProfileEntity likedProfile, ProfileEntity likerProfile){
        likedProfilesEntity = new LikedProfilesEntity();
        likedProfilesEntity.setLikedId(likedProfile);
        likedProfilesEntity.setLikerId(likerProfile);
        likedProfileDoa.save(likedProfilesEntity);
    }

    public void followProfile(ProfileEntity followedProfile, ProfileEntity followerProfile){
        followedProfilesEntity = new FollowedProfilesEntity();
        followedProfilesEntity.setFollowedId(followedProfile);
        followedProfilesEntity.setFollowerId(followerProfile);
        followedProfileDoa.save(followedProfilesEntity);
    }

    public void unlikeProfile(ProfileEntity likerId, ProfileEntity likedId){
        likedProfileDoa.deleteLikedProfile(likerId, likedId);
    }

    public void unfollowProfile(ProfileEntity followerId, ProfileEntity followedId){
        followedProfileDoa.deleteFollowedProfile(followerId, followedId);
    }
}
