package com.in.epfe.services;



import com.in.epfe.entities.EmailDetails;


public interface EmailService {
	String sendSimpleMail(EmailDetails details);
	 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
