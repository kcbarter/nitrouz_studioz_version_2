package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileService;
import java.util.Calendar;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class NewProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/SignUp")
    public String newProfile(Model model,
        HttpSession session,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "join", required = false, defaultValue = "false") boolean join
        ){
        System.out.println(join);
        String message;
        if(email.isEmpty() || password.isEmpty()){
            boolean error = true;
            message = "Field is empty. Please fill out the Form";
            session.setAttribute("error", error);
            session.setAttribute("message", message);
            return "redirect:/signUpForm";
        }
        if(!profileService.emailExists(email)){
            String profileName = email.split("@")[0];
            profileService.createProfile(profileName, email, password, join);
            message = "Verification email sent. Please check your email to activate your account";
            model.addAttribute("verify_email", message);
            return "verifyEmail";
        }
        else{
            boolean error = true;
            message = "User already exists with that email associated it.";
            session.setAttribute("error", error);
            session.setAttribute("message", message);
            return "redirect:/signUpForm";
        }
    }

    @GetMapping("/registrationComplete")
    public String registrationComplete(WebRequest webRequest, HttpSession session, Model model, @RequestParam(name = "token") String token){
        VerificationTokenEntity verificationTokenEntity = profileService.getVerificationToken(token);

        ProfileEntity profileEntity = verificationTokenEntity.getProfileEntity();
        Calendar calendar = Calendar.getInstance();
        String message;

        if(verificationTokenEntity.getExpiredDate().getTime() - calendar.getTime().getTime() <= 0){
            profileService.newVerificationToken(profileEntity);
            message = "This token has expired. A new email has been emailed";
            model.addAttribute("verify_email", message);
            return "verifyEmail";
        }

        profileEntity.setEnabled(true);
        profileService.updateProfile(profileEntity);
        session.setAttribute("success", true);
        message = "Your Email account is now active. Please log in!";
        model.addAttribute("verify_email", message);
        return "verifyEmail";
    }

}
