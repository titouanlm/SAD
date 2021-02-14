package com.example.demo.securitysad.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	void sendEmail(SimpleMailMessage emailMsg);
}
