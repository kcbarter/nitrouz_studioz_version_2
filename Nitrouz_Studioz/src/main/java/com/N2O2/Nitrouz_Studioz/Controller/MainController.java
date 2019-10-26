package com.N2O2.Nitrouz_Studioz.Controller;

import com.N2O2.Nitrouz_Studioz.Model.Email;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/SendEmail")
    public String emailSent(@RequestParam(name = "name") String name,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "subject") String subject){
        System.out.println(name);
        System.out.println(email);
        System.out.println(subject);

        Email emailTo = Email.getSingleton();

        emailTo.sendMessage(name, email, subject);
        return "about";
    }
}
