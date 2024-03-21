package com.darasimi.pagination.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class EmailScheduler {
    private static final Logger logger = LoggerFactory.getLogger(EmailScheduler.class);
    @Autowired
    private EmailService emailService;
    @Value("${email.recipients}")
    private String[] recipients;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.message}")
    private String message;




}
