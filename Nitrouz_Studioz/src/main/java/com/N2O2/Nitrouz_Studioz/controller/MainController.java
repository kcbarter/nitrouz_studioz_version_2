package com.N2O2.Nitrouz_Studioz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @Autowired
//    private Email emailTo;

    @GetMapping("/")
    public String home_page(HttpSession session) {
        return "index";
    }

    @GetMapping("/about")
    public String about_page(HttpSession session){
        return "about";
    }

//    @PostMapping("/SendEmail")
//    public String emailSent(@RequestParam(name = "name") String name,
//        @RequestParam(name = "email") String email,
//        @RequestParam(name = "subject") String subject){
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(subject);
//
//        try {
//            emailTo.sendMessage(name, email, subject);
//            System.out.println("Message sent");
//        }
//        catch (Exception ex){
//            System.out.println("Fail to send message " + ex);
//        }
//        return "about";
//    }
}
