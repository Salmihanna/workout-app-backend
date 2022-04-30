package com.js.workoutappbackend.service;

import com.js.workoutappbackend.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailRepository {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);
    //private final JavaMailSender mailSender;
    private final static String FAILED_SEND_EMAIL_MSG = "Failed to send email";
    private final static String CONFIRM_EMAIL_MSG = "Confirm your email";
    private final static String SET_FROM_EMAIL_ADDRESS = "hello@fabfit.se";

   /* @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(CONFIRM_EMAIL_MSG);
            helper.setFrom(SET_FROM_EMAIL_ADDRESS);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error(FAILED_SEND_EMAIL_MSG, e);
            throw new IllegalStateException(FAILED_SEND_EMAIL_MSG);
        }
    }*/
}
