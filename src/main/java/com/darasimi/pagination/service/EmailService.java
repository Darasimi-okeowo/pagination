package com.darasimi.pagination.service;
import com.darasimi.pagination.dto.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//public interface EmailService {
//    void sendEmailWithAttachment(String csvData) throws MessagingException;
//}

@Service
public class EmailService {

    /*
     * The Spring Framework provides an easy abstraction for sending email by using
     * the JavaMailSender interface, and Spring Boot provides auto-configuration for
     * it as well as a starter module.
     */
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.recipients}")
    private String[] recipients;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.message}")
    private String message;

//    private MultipartFile scheduledFile; // Store the file received in the controller
//
//    public void setScheduledFile(MultipartFile file) {
//        this.scheduledFile = file;
//    }



//    @Scheduled(fixedDelay = 5000) // Execute every 10 seconds
//    public void sendScheduledEmail() {
//        try {
//            if (scheduledFile == null) {
//                System.out.println("No file to send in scheduled email.");
//                return;
//            }
//            List<String> recipientList = Arrays.asList(recipients);
//            // Call the sendEmailWithAttachment method using the scheduled file
//            sendEmailWithAttachment(recipientList, subject, message, scheduledFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void sendEmailWithAttachment(List<String> recipients, String subject, String messageText, MultipartFile file)
            throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        InternetAddress[] recipientAddresses = recipients.stream()
                .map(email -> {
                    try {
                        return new InternetAddress(email);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .toArray(InternetAddress[]::new);

        helper.setTo(recipientAddresses);
        helper.setSubject(subject);
        helper.setText(messageText);

        helper.addAttachment(file.getOriginalFilename(), file);

        javaMailSender.send(mimeMessage);
    }


}
