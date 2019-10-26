package com.N2O2.Nitrouz_Studioz.Model;

import java.util.Properties;

public class Email {
    private String emailTo = "kevanbarter@gmail.com";
    private static Email singleton;

    private Email(){

    }

    public static Email getSingleton(){
        if(singleton == null){
            singleton = new Email();
        }
        return singleton;
    }

    public void sendMessage(String name, String email, String message){
        Properties properties = System.getProperties();
    }
}
