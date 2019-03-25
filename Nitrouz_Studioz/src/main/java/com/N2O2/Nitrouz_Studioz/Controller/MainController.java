package com.N2O2.Nitrouz_Studioz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home_page()
    {
        return "index";
    }
}
