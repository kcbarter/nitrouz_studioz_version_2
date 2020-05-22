package com.N2O2.Nitrouz_Studioz.model.profile;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface ProfileDoa extends JpaRepository<ProfileEntity, Long> {

    public ProfileEntity findByEmail(String email);
}
