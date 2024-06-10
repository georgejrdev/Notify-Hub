package com.georgejrdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.georgejrdev.core.*;


@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String subject, @RequestParam String body, @RequestParam String to) {
        
        try {
            SendEmail sendEmail = new SendEmail();
            sendEmail.sendNewEmail(subject, body, to);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "Email sent successfully to: " + to + " with subject: " + subject;
    }
}