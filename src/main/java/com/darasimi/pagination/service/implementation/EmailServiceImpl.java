//package com.darasimi.pagination.service.implementation;
//
//import com.darasimi.pagination.service.EmailService;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.util.Base64;
//import java.util.Properties;
//
//@Service
//public class EmailServiceImpl implements EmailService {
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Override
//    public void sendEmailWithAttachment(String csvData) throws MessagingException {
//
//        //create an instance of the java mail sender
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setProtocol("SMTP");
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(465);
//        mailSender.setUsername("okeowodarasimidavid19@gmail.com");
//        mailSender.setPassword("Okemoney19#");
////
////        Properties properties= mailSender.getJavaMailProperties();
////        properties.put("mail.transport.protocol","smtp");
////        properties.put("mail.smtp.auth","true");
////        properties.put("mail.smtp.starttls.enable","true");
////        properties.put("mail.smtp.ssl.enable","true");
////        properties.put("mail.debug","true");
////        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
////        JavaMailSender javaMailSender= mailSender;
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo("okeowodarasimidavid19@gmail.com");
//        helper.setSubject("Subject of the email");
//        helper.setText("Body of the email:\n\n" + csvData);
//        // You can attach the CSV file here if needed
//         helper.addAttachment("Excelsheet.xlsx", new ByteArrayResource(csvData.getBytes()));
//
//        javaMailSender.send(message);
//    }
//}
