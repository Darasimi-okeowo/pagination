package com.darasimi.pagination.controller;

import com.darasimi.pagination.dto.EmailRequest;
import com.darasimi.pagination.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailRequest emailRequest;

    @Value("${email.recipients}")
    private String[] recipients;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.message}")
    private String message;

//    @PostMapping("/send-email")
//    public ResponseEntity<String> sendEmailWithAttachment(@RequestParam("file") MultipartFile file) {
//        try {
//            // Send email with attachment
//            emailService.sendEmailWithAttachment(file);
//            return ResponseEntity.ok("Email sent successfully.");
//        } catch (IOException | MessagingException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
//        }
//    }

    @PostMapping("/send-email")
    public ResponseEntity<Map<String, String>> sendEmailWithAttachment(@RequestParam("file") MultipartFile file) {
        try {
//            emailService.setScheduledFile(file);
            List<String> recipientList = Arrays.asList(recipients);
            emailService.sendEmailWithAttachment(recipientList, subject, message, file);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email sent successfully.");
            return ResponseEntity.ok().body(response);
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to send email.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
