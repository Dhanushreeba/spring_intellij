package com.xworkz.project.controller;


import com.xworkz.project.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProfileController {

    @Autowired
    private SignUpService signUpService;

    ProfileController(){
        System.out.println("creating ProfileController");
    }

    @PostMapping("profile")
    public String upload(){

        return "";
    }
}
