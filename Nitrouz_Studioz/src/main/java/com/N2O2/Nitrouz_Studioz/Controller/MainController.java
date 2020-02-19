package com.N2O2.Nitrouz_Studioz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home_page(HttpSession session) {
        return "index";
    }

    @GetMapping("/about")
    public String about_page(HttpSession session){
        return "about";
    }

    @GetMapping("/signin")
    public String sign_in(HttpSession session){
        return "signin";
    }
}
