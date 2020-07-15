package com.N2O2.Nitrouz_Studioz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String log_in(){
        return "login";
    }

    @GetMapping("/logOut")
    public String logOut(){
        return "redirect:/index";
    }
}
