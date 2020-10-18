package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private ProfileDoa profileDoa;

    public List<ProfileEntity> getAllProfiles(){
        List<ProfileEntity> profiles;
        profiles = profileDoa.findAll();
        return profiles;
    }
}
