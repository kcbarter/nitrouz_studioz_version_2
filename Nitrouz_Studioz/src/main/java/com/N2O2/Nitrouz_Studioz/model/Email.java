package com.N2O2.Nitrouz_Studioz.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email {
    private JavaMailSender sender;
    private String emailTo = "kevanballer@gmail.com";

    @Autowired
    public Email(JavaMailSender sender){
        this.sender = sender;
    }

    public void sendMessage(String name, String email, String subject) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailTo);
        mail.setFrom(email);
        mail.setReplyTo(email);
        mail.setSubject("From: " + name);
        mail.setText(subject);
        

        sender.send(mail);
    }
}
