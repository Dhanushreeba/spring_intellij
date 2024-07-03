package com.xworkz.project.Controller;

import com.xworkz.project.model.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AjaxEmailController {

    @Autowired
    private SystemService systemService;


    AjaxEmailController()
    {
        System.out.println("Created AjaxEmailController..");
    }

    @GetMapping("/validateEmail/{email}")
    public String emailValidation(@PathVariable String email) {
        System.out.println(email);
        if(systemService.existsByEmail(email)) {
            return "Email Already exists";
        }else{
            return null;
        }
    }

}

