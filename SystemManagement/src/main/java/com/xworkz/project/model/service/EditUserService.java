package com.xworkz.project.model.service;


import com.xworkz.project.dto.SignUpDto;

public interface EditUserService {

    SignUpDto findByEmail(String email);


    SignUpDto editByEmail(SignUpDto dto);

}
