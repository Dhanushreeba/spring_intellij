package com.xworkz.project.controller;

import com.xworkz.project.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//to avoid duplicate entries of email I used Ajax seperate controller

//@RestController is to
@RestController
@RequestMapping("/")
public class AjaxEmailController {

    @Autowired
    private SignUpService signUpService;


    AjaxEmailController()
    {
        System.out.println("Created constr AjaxEmailController..");
    }

    //getmapping is used to map the action "validateEmail" in init class
    @GetMapping("/validateEmail/{email}")
    public String emailValidating(@PathVariable String email) {
        //this print statement is to print email in console
        System.out.println(email);
        //this is to check the whether email is exits or not
        if(signUpService.existsByEmail(email)) {
            return  "<span style='color:red;'>Email Already exists</span>";
        }else{
            return null;
        }
    }


    @GetMapping("/validateContactNumber/{contactNumber}")
    public String contactNumberValidating(@PathVariable Long contactNumber) {
        System.out.println(contactNumber);
        if (signUpService.existsByContactNumber(contactNumber)) {
            return "<span style='color:red;'>Contact Number Already exists</span>";
        } else {
            return null;
        }
    }

}

