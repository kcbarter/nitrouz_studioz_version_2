package com.N2O2.Nitrouz_Studioz.model.ProfileService;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface ProfileDoa extends CrudRepository<Profile, Long> {

    public Profile findByEmail(String email);
}
