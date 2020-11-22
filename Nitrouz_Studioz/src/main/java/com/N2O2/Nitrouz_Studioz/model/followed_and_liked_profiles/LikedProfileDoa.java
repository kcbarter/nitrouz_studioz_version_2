package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LikedProfileDoa extends JpaRepository<LikedProfilesEntity, Long> {
    @Query("SELECT id FROM LikedProfilesEntity id WHERE id.likerId = ?1")
    public List<LikedProfilesEntity> getByLikerId(ProfileEntity profileEntity);
}
