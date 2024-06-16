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

    @Test(expected = RuntimeException.class)
    public void testSendNewEmailWithInvalidEmail() {
        sendEmail.sendNewEmail("Hi", "how are you?", "invalid-email");
    }

    @Test(expected = RuntimeException.class)
    public void testSendNewEmailWithoutAtSing() {
        sendEmail.sendNewEmail("Hi", "how are you?", "invalidgmail.com");
    }

    @Test(expected = RuntimeException.class)
    public void testSendNewEmailNoDot() {
        sendEmail.sendNewEmail("Hi", "how are you?", "invalid@gmailcom");
    }
}