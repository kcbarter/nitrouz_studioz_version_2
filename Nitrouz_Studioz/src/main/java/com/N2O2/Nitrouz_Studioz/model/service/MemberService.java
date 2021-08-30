package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.FollowedProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.FollowedProfilesEntity;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.LikedProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles.LikedProfilesEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Long> likedIds = likedProfileDoa.getByLikerId(profile.getId());
        List<ProfileEntity> likedProfiles = new ArrayList<>();
        for(Long ids : likedIds){
            likedProfiles.add(profileDoa.getById(ids));
        }
        return likedProfiles;
    }

    public List <ProfileEntity> getProfilesFollowedByUser(ProfileEntity profile){
        List<Long> followedIds = followedProfileDoa.getByFollowerId(profile.getId());
        List<ProfileEntity> followedProfiles = new ArrayList<>();
        for(Long ids : followedIds){
            followedProfiles.add(profileDoa.getById(ids));
        }
        return followedProfiles;
    }

    public void likeProfile(ProfileEntity likedProfile, ProfileEntity likerProfile){
        likedProfilesEntity = new LikedProfilesEntity();
        likedProfilesEntity.setLiked_Id(likedProfile.getId());
        likedProfilesEntity.setLiker_Id(likerProfile.getId());
        likedProfileDoa.save(likedProfilesEntity);
    }

    public void followProfile(ProfileEntity followedProfile, ProfileEntity followerProfile){
        followedProfilesEntity = new FollowedProfilesEntity();
        followedProfilesEntity.setFollowed_Id(followedProfile.getId());
        followedProfilesEntity.setFollower_Id(followerProfile.getId());
        followedProfileDoa.save(followedProfilesEntity);
    }

    public void unlikeProfile(ProfileEntity likerId, ProfileEntity likedId){
        likedProfileDoa.deleteLikedProfile(likerId.getId(), likedId.getId());
    }

    public void unfollowProfile(ProfileEntity followerId, ProfileEntity followedId){
        followedProfileDoa.deleteFollowedProfile(followerId.getId(), followedId.getId());
    }
}
