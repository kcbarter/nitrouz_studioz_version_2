package com.N2O2.Nitrouz_Studioz.model.ProfileService;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface ProfileDoa extends JpaRepository<Profile, Long> {

    public Profile findByEmail(String email);
}
