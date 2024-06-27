package com.xworkz.project.model.repo;

import com.xworkz.project.dto.SystemDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface SystemRepo {

    // Save and validate the DTO
    boolean saveAndValidation(SystemDto dto);

    //to generate password
    // Find a SystemDto by email and password
    SystemDto findByPassword(String email, String password);



}
