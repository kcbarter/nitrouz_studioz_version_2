package com.N2O2.Nitrouz_Studioz.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home_page(HttpSession session) {
        return "index";
    }

    @GetMapping("/about")
    public String about_page(HttpSession session){
        return "about";
    }
}
