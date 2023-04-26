package com.in.epfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in.epfe.entities.EmailDetails;
import com.in.epfe.services.EmailService;

@Controller
//Class
public class EmailController {

 @Autowired 
 private EmailService emailService;

 // Sending a simple Email
 @PostMapping("/sendMail")
 @ResponseBody
 public String sendMail(@RequestBody EmailDetails details)
 {
     String status= emailService.sendSimpleMail(details);

     return status;
 }

 // Sending email with attachment
 @PostMapping("/sendMailWithAttachment")
 @ResponseBody
 public String sendMailWithAttachment(@RequestBody EmailDetails details)
 {
     String status= emailService.sendMailWithAttachment(details);

     return status;
 }
}
