package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.role.RoleEntity;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfileDetailsService implements UserDetailsService {
    @Autowired
    private ProfileService profileService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ProfileEntity profileEntity = profileService.findProfileByEmail(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleEntity role : profileEntity.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoles()));
        }

        return new org.springframework.security.core.userdetails.User(profileEntity.getEmail(), profileEntity.getPassword(), grantedAuthorities);
    }
}
