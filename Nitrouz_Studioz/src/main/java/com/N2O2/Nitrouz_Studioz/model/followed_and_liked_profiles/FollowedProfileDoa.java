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

    @Query("SELECT id.followed_Id FROM FollowedProfilesEntity id WHERE id.follower_Id = ?1")
    public List<Long> getByFollowerId(Long profileEntity);

    @Modifying
    @Query("DELETE FROM FollowedProfilesEntity WHERE follower_Id = :follower_Id AND followed_Id = :followed_Id")
    public void deleteFollowedProfile(@Param("follower_Id") Long follower_Id, @Param("followed_Id") Long followed_Id);
}
