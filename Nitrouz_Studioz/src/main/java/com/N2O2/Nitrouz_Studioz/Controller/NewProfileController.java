package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenDoa;
import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewProfileController {

    @Autowired
    ProfileService profileService;

    private VerificationTokenEntity verificationTokenEntity;
    @Autowired
    private VerificationTokenDoa verificationTokenDoa;

    @PostMapping("/SignUp")
    public String newProfile(@RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "join") boolean join){
        if(!profileService.emailExists(email)){
            String profileName = email.split("@")[0];
            profileService.createProfile(profileName, email, password, join);

            return "verfyEmail";
        }
        else{
            // TODO: 5/14/2020 implement redirect back to signUpForm with reason why
            return "signUpForm";
        }
    }

    @GetMapping("/registrationComplete")
    public String registrationComplete(){

        return "";
    }
}
