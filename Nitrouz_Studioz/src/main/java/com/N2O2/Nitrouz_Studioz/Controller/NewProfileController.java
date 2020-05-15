package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.profileService.Profile;
import com.N2O2.Nitrouz_Studioz.model.profileService.ProfileDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewProfileController {

    private Profile profile;
    @Autowired
    private ProfileDoa profileDoa;

    @PostMapping("/SignUp")
    public String newProfile(@RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "join") boolean join){
        if(!emailExists(email)){
            String profileName = email.split("@")[0];
            profile = new Profile(null, profileName, null, email, null, null, password,
                join, join, join, join, false);
            profileDoa.save(profile);
            // TODO: 5/14/2020 add to VerificationToken Entity and and VerificationToke JPA repository 

            return "verfyEmail";
        }
        else{
            // TODO: 5/14/2020 implement redirect back to signUpForm with reason why
            return "signUpForm";
        }
    }

    private boolean emailExists(String email){
        return profileDoa.findByEmail(email) != null;
    }
}
