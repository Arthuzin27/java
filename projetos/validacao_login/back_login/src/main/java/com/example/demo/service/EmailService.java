package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCodigo(String email, String codigo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("arthurlopesclemente@gmail.com");
        message.setTo(email);
        message.setSubject("Recuperação de senha");
        message.setText("Seu código de recuperação é: " + codigo);

        mailSender.send(message);
    }
}