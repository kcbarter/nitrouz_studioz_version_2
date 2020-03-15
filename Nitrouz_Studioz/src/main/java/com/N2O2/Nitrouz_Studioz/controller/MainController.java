package com.N2O2.Nitrouz_Studioz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private boolean loggedIn = false;

    @GetMapping("/")
    public String home_page(HttpSession session) {

        if(loggedIn){
            String userName = "KevanBaller";
            session.setAttribute("UserName", userName);
            return "index";
        }
        return "index";
    }

    @GetMapping("/about")
    public String about_page(HttpSession session){
        if(loggedIn){
            String userName = "KevanBaller";
            session.setAttribute("UserName", userName);
            return "about";
        }
        return "about";
    }

    @GetMapping("/signup")
    public String sign_up(HttpSession session){
        if(loggedIn){
            String userName = "KevanBaller";
            session.setAttribute("UserName", userName);
            return "signup";
        }
        return "signup";
    }

    @GetMapping("/login")
    public String log_in(HttpSession session){
        return "login";
    }

    @PostMapping("/Log_In")
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
}
