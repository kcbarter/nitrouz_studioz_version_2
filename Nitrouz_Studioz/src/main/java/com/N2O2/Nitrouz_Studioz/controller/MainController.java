package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private boolean loggedOut = true;
    private boolean loggedIn = false;
    private ProfileEntity profileEntity;
    @Autowired
    private ProfileDoa profileDoa;

    @RequestMapping("/")
    public String home_page(Model model) {
        model.addAttribute("loggedOut", loggedOut);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("profileEntity", "Not logged In");
        return "index";
    }

    @RequestMapping("/about")
    public String about_page(Model model){
        model.addAttribute("loggedOut", loggedOut);
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("profileEntity", "Not logged In");
        return "about";
    }

    @RequestMapping("/signup")
    public String sign_up(){
        return "signup";
    }

    @GetMapping("/signUpForm")
    public String signUpForm(Model model, ProfileEntity profileEntity){
        boolean checked = false;
        model.addAttribute("profileEntity", profileEntity);
        model.addAttribute("join", checked);
        return "signUpForm";
    }

    @RequestMapping("/signUpFormError")
    public String signUpFormError(Model model,
            @ModelAttribute("error") boolean error,
            @ModelAttribute("message") String message,
            ProfileEntity profileEntity){
        boolean checked = false;
        model.addAttribute("join", checked);
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        model.addAttribute("profileEntity", profileEntity);
        return "signUpForm";
    }

    @RequestMapping("/ForgotPasswordPage")
    public String forgotPasswordPage(){
        return "forgotPassword";
    }

    @GetMapping("/Forgot_Password")
    public String ForgotPasswordResponse(){
        return "forgotPassword";
    }
}
