package com.georgejrdev.core;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.georgejrdev.core.interfaces.InterfaceSendEmail;

public class SendEmail implements InterfaceSendEmail {

    private String emailServer;
    private String emailServerHost;
    private Session session;
    private String email;
    private String password;

    public SendEmail() throws Exception {
        setEmailServer(System.getenv("EMAIL_SERVER"));
        setEmail();
        setPassword();
        configureEmailHost();
        configureEmailSending();
    }

    @Override
    public void sendNewEmail(String subject, String body, String to) {
        try {
            checkEmailValidity(to);

            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(to));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void configureEmailHost() throws Exception {
        switch (this.emailServer.toLowerCase()) {
            case "gmail":
                setEmailServerHost("smtp.gmail.com");
                break;

            case "outlook":
                setEmailServerHost("smtp.office365.com");
                break;

            case "yahoo":
                setEmailServerHost("smtp.mail.yahoo.com");
                break;

            case "zoho":
                setEmailServerHost("smtp.zoho.com");
                break;

            default:
                throw new Exception("Email Server Not Found");
        }
    }

    private void configureEmailSending() {
        Properties props = new Properties();
        props.put("mail.smtp.host", getEmailServerHost());
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        setSession(Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(getEmail(), getPassword());
            }
        }));
    }

    private void checkEmailValidity(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }

    private void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    @SuppressWarnings("unused")
    private String getEmailServer() {
        return this.emailServer;
    }

    private void setEmailServerHost(String emailServerHost) {
        this.emailServerHost = emailServerHost;
    }

    private String getEmailServerHost() {
        return this.emailServerHost;
    }

    private void setSession(Session session) {
        this.session = session;
    }

    private Session getSession() {
        return this.session;
    }

    private void setEmail() {
        this.email = System.getenv("EMAIL");
    }

    private String getEmail() {
        return this.email;
    }

    private void setPassword() {
        this.password = System.getenv("EMAIL_APP_PASSWORD");
    }

    private String getPassword() {
        return this.password;
    }
}