package by.itransition.dpm.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import by.itransition.dpm.entity.User;

public class SimpleUserActivator implements UserActivator{

    private MailSender mailSender;
    private SimpleMailMessage message;


    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMessage(SimpleMailMessage message) {
        this.message = message;
    }

    public void activateUser(User user) {

        message.setFrom("MusicUploader");
        message.setTo("liomsv@gmail.com");
        message.setSubject("Activation");
        message.setText("Hi! This is me!!!");
        mailSender.send(message);
    }
}