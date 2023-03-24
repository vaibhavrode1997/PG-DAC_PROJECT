package com.demo.EventManagementPortal.service;

import org.springframework.mail.MailException;

public interface IEmailSenderService {

	String sendOTPEmail(String toEmail,String body,String subject)throws MailException,InterruptedException;
}
