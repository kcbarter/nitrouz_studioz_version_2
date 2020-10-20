package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FollowedProfileDoa extends JpaRepository<FollowedProfilesEntity, Long> {

    public ProfileEntity getByFollowerId(ProfileEntity profileEntity);
}