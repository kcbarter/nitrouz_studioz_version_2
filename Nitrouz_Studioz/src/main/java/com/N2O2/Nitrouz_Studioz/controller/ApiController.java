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
        profileEntity = loggedInUser();
        ProfileEntity likedProfile = profileService.findProfileByEmail(email);
        memberService.likeProfile(likedProfile, profileEntity);
    }

    @RequestMapping("/follow/{email:.+}")
    public void followProfile(@PathVariable String email){
        profileEntity = loggedInUser();
        ProfileEntity followProfile = profileService.findProfileByEmail(email);
        memberService.followProfile(followProfile, profileEntity);
    }

    @RequestMapping("/unlike/{email:.+}")
    public void unlikeProfile(@PathVariable String email){
        profileEntity = loggedInUser();
        ProfileEntity unlikeProfile = profileService.findProfileByEmail(email);
        memberService.unlikeProfile(profileEntity, unlikeProfile);
    }

    @RequestMapping("/unfollow/{email:.+}")
    public void unfollowProfile(@PathVariable String email){
        profileEntity = loggedInUser();
        ProfileEntity unfollowProfile = profileService.findProfileByEmail(email);
        memberService.unfollowProfile(profileEntity, unfollowProfile);
    }

    private ProfileEntity loggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return profileService.findProfileByEmail(auth.getName());
    }
}
