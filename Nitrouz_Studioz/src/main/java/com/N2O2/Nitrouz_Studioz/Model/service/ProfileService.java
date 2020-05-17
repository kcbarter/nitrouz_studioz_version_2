package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenDoa;
import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileEntity profileEntity;
    @Autowired
    private ProfileDoa profileDoa;
    private VerificationTokenEntity verificationTokenEntity;
    @Autowired
    private VerificationTokenDoa verificationTokenDoa;

    public void createProfile(String profileName, String email, String password, boolean join){
        profileEntity = new ProfileEntity(null, profileName, null, email, null, null, password,
            join, join, join, join, false);
        profileDoa.save(profileEntity);

        confirmEmail(email, profileEntity);
    }

    public boolean emailExists(String email){
        return profileDoa.findByEmail(email) != null;
    }


    private void confirmEmail(String email, ProfileEntity profileEntity){
        String token = UUID.randomUUID().toString();
        verificationTokenEntity = new VerificationTokenEntity(token, profileEntity);
        verificationTokenDoa.save(verificationTokenEntity);

        
    }
}
