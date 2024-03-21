package com.darasimi.pagination.dto;

import org.springframework.stereotype.Component;

@Component
public class EmailRequest {
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
