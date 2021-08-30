package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LikedProfileDoa extends JpaRepository<LikedProfilesEntity, Long> {
    @Query("SELECT id.liked_Id FROM LikedProfilesEntity id WHERE id.liker_Id = ?1")
    public List<Long> getByLikerId(Long profileEntity);

    @Modifying
    @Query("DELETE FROM LikedProfilesEntity WHERE liker_Id = :liker_Id AND liked_Id = :liked_Id")
    public void deleteLikedProfile(@Param("liker_Id") Long liker_Id, @Param("liked_Id") Long liked_Id);
}
