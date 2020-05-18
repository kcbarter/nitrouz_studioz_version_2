package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileService;
import java.util.Calendar;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class NewProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/SignUp")
    public String newProfile(HttpSession session,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "join") boolean join
        ){
        // TODO: 5/17/2020 add landing page for success verfyEmail and solve join by sending checkbox value here
        if(email.isEmpty() || password.isEmpty()){
            boolean error = true;
            String message = "Field is empty. Please fill out the Form";
            session.setAttribute("error", error);
            session.setAttribute("message", message);
            return "redirect:/signUpForm";
        }
        if(!profileService.emailExists(email)){
            String profileName = email.split("@")[0];
            profileService.createProfile(profileName, email, password, join);

            return "verfyEmail";
        }
        else{
            boolean error = true;
            String message = "User already exists with that email associated it.";
            session.setAttribute("error", error);
            session.setAttribute("message", message);
            return "redirect:/signUpForm";
        }
    }

    @GetMapping("/registrationComplete")
    public String registrationComplete(WebRequest webRequest, HttpSession session, @RequestParam(name = "token") String token){
        VerificationTokenEntity verificationTokenEntity = profileService.getVerificationToken(token);

        ProfileEntity profileEntity = verificationTokenEntity.getProfileEntity();
        Calendar calendar = Calendar.getInstance();

        if(verificationTokenEntity.getExpiredDate().getTime() - calendar.getTime().getTime() <= 0){
            session.setAttribute("error", "This token has expired. A new email has been emailed");
            profileService.newVerificationToken(profileEntity);
        }

        profileEntity.setEnabled(true);
        profileService.updateProfile(profileEntity);
        // TODO: 5/17/2020 add landing page and getting email to send properly
        return "";
    }

}
