package com.xworkz.project.model.service;

import com.xworkz.project.dto.SystemDto;
import com.xworkz.project.model.repo.SystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class SystemServiceImpl implements SystemService{

    @Autowired
    private SystemRepo systemRepo;


    @Autowired
    private JavaMailSender mailSender;


    //password lock
    private Map<String, Integer> failedAttemptsMap = new HashMap<>();
    private Map<String, SystemDto> users = new HashMap<>(); // Simulated database

   // private static final Logger logger = Logger.getLogger(SystemServiceImpl.class.getName());


    public SystemServiceImpl(){
        System.out.println("running constr for SystemServiceImpl class");
    }

    @Override
    public boolean save(SystemDto dto) {

        System.out.println("save method from SystemServiceImpl");

        setAuditValues(dto,"Dhanu",LocalDateTime.now(),"NA",null,true);

        boolean save=systemRepo.saveAndValidation(dto);
        if (save){
            System.out.println("Repo save in search successfull "+dto);
        }else{
            System.out.println("Repo save in search not successfull "+dto);
        }
        users.put(dto.getEmail(), dto); // Simulate saving to a database//password locking
        return true;
    }

    @Override
    public void setAuditValues(SystemDto dto, String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn, boolean isActive) {
        dto.setCreatedBy(createdBy);
        dto.setCreatedOn(createdOn);
        dto.setUpdatedBy(updatedBy);
        dto.setActive(isActive);
    }

    @Override
    public SystemDto findByPassword(String email, String password) {
        //password lock statements
        SystemDto user = users.get(email);
        if (user != null && !user.isAccLocked() && user.getPassword().equals(password)) {
            return user;
        }

        return systemRepo.findByPassword(email,password);
    }

 //   private Map<String, SystemDto> users = new HashMap<>();


//    public void sendingEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
//    }

    //send email to get otp
    @Override
    public void sendingEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("dhanushreegowda1999@gmail.com");

        mailSender.send(message);
    }


    //account lock after 3 attempts
    @Override
    public void incrementFailedAttempts(String email) {
        int attempts = failedAttemptsMap.getOrDefault(email, 0) + 1;
        failedAttemptsMap.put(email, attempts);
        if (attempts >= 3) {
            lockAccount(email);
        }

    }

    @Override
    public int getFailedAttempts(String email) {
        return failedAttemptsMap.getOrDefault(email, 0);
    }

    @Override
    public void resetFailedAttempts(String email) {
        failedAttemptsMap.remove(email);

    }

    @Override
    public void lockAccount(String email) {

        SystemDto user = users.get(email);
        if (user != null) {
            user.setAccLocked(true);
        }
    }

}
