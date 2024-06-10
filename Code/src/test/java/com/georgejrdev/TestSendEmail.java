package com.georgejrdev;

import org.junit.Before;
import org.junit.Test;

import com.georgejrdev.core.SendEmail;


public class TestSendEmail {

    private SendEmail sendEmail;

    @Before
    public void setUp() throws Exception{
        sendEmail = new SendEmail();
    }

    @Test
    public void testSendNewEmail(){
        sendEmail.sendNewEmail("Hi","how are you?","mail@iconscout.com");
    }
}