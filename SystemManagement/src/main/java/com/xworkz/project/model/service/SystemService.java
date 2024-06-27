package com.xworkz.project.model.service;

import com.xworkz.project.dto.SystemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.time.LocalDateTime;

public interface SystemService {

    public boolean save(SystemDto dto);

//    public LocalDateTime currentDateTime(SystemDto dto);

 //  public void setCurrentDateTime(SystemDto dto, String dateTimeStr, String format);

    void setAuditValues(SystemDto dto,String createdBy,LocalDateTime createdOn,String updatedBy,LocalDateTime updatedOn,boolean isActive);

    SystemDto findByPassword(String email,String password);

  //  public String generateRandomPassword();

    public void sendingEmail(String to, String subject, String body);

    //checking wrong password and lock the account


    void incrementFailedAttempts(String email);

    int getFailedAttempts(String email);

    void resetFailedAttempts(String email);

    void lockAccount(String email);

    // void incrementFailedAttempt(String email);

    //  public int getFailedAttempt(String email);

}

