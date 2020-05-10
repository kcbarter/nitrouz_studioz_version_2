package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.ProfileService.Profile;
import com.N2O2.Nitrouz_Studioz.model.ProfileService.ProfileDoa;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private boolean loggedIn = false;
    private Profile profile;
    private ProfileDoa profileDoa;

    @RequestMapping("/")
    public String home_page(HttpSession session) {

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
