package com.N2O2.Nitrouz_Studioz.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailTest {
    @Autowired
    private Email email;
    private String name = "Anthony";
    private String sentFrom = "anthony@live.com";
    private String subject = "Let's go to the club this weekend";
    private String result;

    @Test
    void emailWasSent() {
        try {
            result = "Message was sent";
            email.sendMessage(name, sentFrom, subject);
        }
        catch (Exception ex){
            result = "Error: " + ex;
            ex.printStackTrace();
        }

        assertEquals("Message was sent", result);
    }
}
