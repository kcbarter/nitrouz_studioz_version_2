package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.service.MemberService;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {
    @Autowired
    ProfileService profileService;
    @Autowired
    MemberService memberService;

    private ProfileEntity profileEntity;

    @RequestMapping("/like/{email:.+}")
    public void likeProfile(@PathVariable String email){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        profileEntity = profileService.findProfileByEmail(auth.getName());
        ProfileEntity likedProfile = profileService.findProfileByEmail(email);
        memberService.likeProfile(likedProfile, profileEntity);
    }

    @RequestMapping("/follow/{email:.+}")
    public void followProfile(@PathVariable String email){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        profileEntity = profileService.findProfileByEmail(auth.getName());
        ProfileEntity followProfile = profileService.findProfileByEmail(email);
        memberService.followProfile(followProfile, profileEntity);
    }

    @RequestMapping("/unlike")
    public void unlikeProfile(){

    }

    @RequestMapping("/unfollow")
    public void unfollowProfile(){

    }
}
