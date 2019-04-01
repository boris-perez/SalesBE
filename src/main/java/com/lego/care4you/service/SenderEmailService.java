package com.lego.care4you.service;


import com.lego.care4you.domain.Customer;
import com.lego.care4you.framework.emil.EmailService;
import com.lego.care4you.framework.emil.model.Email;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Arrays;

@Service
public class SenderEmailService {

    private EmailService emailService;


    public SenderEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(Customer customer) {
        Email email = composeEmail(customer);
        try {
            emailService.send(email);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
        }
    }

    private Email composeEmail(Customer customer) {
        Email email = new Email();
        email.setFrom(customer.getEmail());
        email.setTo(Arrays.asList("diplomadodhv2@gmail.com"));
        email.setSubject("Message of Customer: " + customer.getFirstName() + " " + customer.getLastName());
        email.setBody(customer.getComment());
        return email;
    }
}
