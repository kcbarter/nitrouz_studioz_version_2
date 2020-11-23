package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LikedProfileDoa extends JpaRepository<LikedProfilesEntity, Long> {
    @Query("SELECT id.likedId FROM LikedProfilesEntity id WHERE id.likerId = ?1")
    public List<ProfileEntity> getByLikerId(ProfileEntity profileEntity);

    @Modifying
    @Query("DELETE FROM LikedProfilesEntity WHERE likerId = :likerId AND likedId = :likedId")
    public void deleteLikedProfile(@Param("likerId") ProfileEntity likerId, @Param("likedId") ProfileEntity likedId);
}
