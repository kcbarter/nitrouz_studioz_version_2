package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FollowedProfileDoa extends JpaRepository<FollowedProfilesEntity, Long> {

    @Query("SELECT id.followedId FROM FollowedProfilesEntity id WHERE id.followerId = ?1")
    public List<ProfileEntity> getByFollowerId(ProfileEntity profileEntity);

    @Modifying
    @Query("DELETE FROM FollowedProfilesEntity WHERE followerId = :followerId AND followedId = :followedId")
    public void deleteFollowedProfile(@Param("followerId") ProfileEntity followerId, @Param("followedId") ProfileEntity followedId);
}
