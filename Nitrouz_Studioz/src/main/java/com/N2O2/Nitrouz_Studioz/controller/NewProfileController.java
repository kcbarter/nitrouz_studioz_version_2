package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileService;
import java.util.Calendar;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/SignUp")
    public String newProfile(Model model,
        RedirectAttributes redirectAttributes,
        @RequestParam(name = "join", required = false, defaultValue = "false") boolean join,
        @Valid ProfileEntity profileEntity,
        BindingResult bindingResult
        ){
        String message;
        if(bindingResult.hasErrors()){
            boolean error = true;
            message = signUpFormErrorMessage(profileEntity.getEmail(), profileEntity.getPassword());
            redirectAttributes.addFlashAttribute("error", error);
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/signUpFormError";
        }
        if(!profileService.emailExists(profileEntity.getEmail())){
            String profileName = profileEntity.getEmail().split("@")[0];
            profileEntity.setProfileName(profileName);
            profileService.createProfile(join, profileEntity);
            message = "Verification email sent. Please check your email to activate your account";
            model.addAttribute("verify_email", message);
            return "verifyEmail";
        }
        else{
            boolean error = true;
            message = "User already exists with that email associated it.";
            redirectAttributes.addFlashAttribute("error", error);
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/signUpFormError";
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
        profileService.createRole(profileEntity);
        model.addAttribute("success", true);
        message = "Your Email account is now active. Please log in!";
        model.addAttribute("verify_email", message);
        return "verifyEmail";
    }

    private String signUpFormErrorMessage(String email, String password){
        String result = "";
        if(email.isEmpty() && password.isEmpty()){
            result = "Please fill in Email and Password";
        }
        else if(email.isEmpty()){
            result = "Please fill in email";
        }
        else if(password.isEmpty()){
            result = "Please fill in password";
        }
        else if(password.length() < 8){
            result = "Password length must be greater than 8";
        }

        return result;
    }
}
