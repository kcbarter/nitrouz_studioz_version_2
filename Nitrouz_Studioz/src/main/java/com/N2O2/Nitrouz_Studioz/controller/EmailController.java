package com.N2O2.Nitrouz_Studioz.controller;

import com.N2O2.Nitrouz_Studioz.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    private Email emailTo;

    @PostMapping("/SendEmail")
    public String emailSent(@RequestParam(name = "name") String name,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "subject") String subject){
        System.out.println(name);
        System.out.println(email);
        System.out.println(subject);

        try {
            System.out.println("Message sent");
            emailTo.sendMessage(name, email, subject);
        }
        catch (Exception ex){
            System.out.println("Fail to send message " + ex);
        }
        return "about";
    }
}
