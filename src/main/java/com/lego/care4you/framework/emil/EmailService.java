package com.lego.care4you.framework.emil;

import com.lego.care4you.framework.emil.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void send(Email email) throws MailException, MessagingException {

        validateMessage(email);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        messageHelper.setTo(email.getTo().toArray(new String[email.getTo().size()]));
        messageHelper.setFrom(email.getFrom());
        messageHelper.setSubject(email.getSubject());
        messageHelper.setSentDate(new Date());
        messageHelper.setText(email.getBody(), true);

        mailSender.send(messageHelper.getMimeMessage());
    }

    private void validateMessage(Email email) {
        if (null == email.getTo() || null == email.getFrom() || null == email.getSubject() || null == email.getBody()) {
            throw new IllegalArgumentException("to, from, subject and text cannot be null");
        }
    }
}
