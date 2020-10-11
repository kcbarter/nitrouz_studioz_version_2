package com.N2O2.Nitrouz_Studioz.model.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProfileDoa extends JpaRepository<ProfileEntity, Long> {

    public ProfileEntity findByEmail(String email);

    public List<ProfileEntity> findAll();
}
