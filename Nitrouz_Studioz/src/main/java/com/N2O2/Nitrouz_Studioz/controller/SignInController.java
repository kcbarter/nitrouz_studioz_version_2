package com.N2O2.Nitrouz_Studioz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SignInController {


    @PostMapping("/Log_In")
    public String logInAttmpt(
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password){

        return "redirect:/index?LoggedIn=true";
    }

    @GetMapping("/index?LoggedIn=true")
    public String homePage_loggedIn(HttpSession session){

        String userName = "KevanBaller";
        session.setAttribute("userName", userName);

        return "index";
    }
}
