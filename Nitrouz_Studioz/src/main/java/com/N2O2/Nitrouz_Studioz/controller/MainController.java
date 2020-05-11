package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.ProfileService.Profile;
import com.N2O2.Nitrouz_Studioz.model.ProfileService.ProfileDoa;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private boolean loggedIn = false;
    private Profile profile;
    @Autowired
    private ProfileDoa profileDoa;

    @RequestMapping("/")
    public String home_page(HttpSession session) {
//        String profileName;
//        profile = profileDoa.findByEmail("kcbarter@msn.com");
//        profileName = String.valueOf(profile.getProfileName());
//        System.out.println("Profile Name is: " + profileName);

        profile = new Profile(null, "KingJames", null, "LebronJames@gmail.com", null, null, "KingJames", true, true, true, true);
        profileDoa.save(profile);

        if(loggedIn){
            String userName = "KevanBaller";
            session.setAttribute("UserName", userName);
            return "index";
        }
        return "index";
    }

    @RequestMapping("/about")
    public String about_page(HttpSession session){
        if(loggedIn){
            String userName = "KevanBaller";
            session.setAttribute("UserName", userName);
            return "about";
        }
        return "about";
    }

    @RequestMapping("/signup")
    public String sign_up(HttpSession session){
        return "signup";
    }

    @RequestMapping("/login")
    public String log_in(HttpSession session){
        return "login";
    }

    @RequestMapping("/signUpForm")
    public String signUpForm(HttpSession session){
        return "signUpForm";
    }

    @GetMapping("/Log_In")
    public String logInAttmpt(
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password){

        loggedIn = true;
        return "redirect:/index";
    }

    @GetMapping("/logOut")
    public String logOut(){
        loggedIn = false;
        return "redirect:/index";
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
