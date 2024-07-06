package com.xworkz.project.controller;

import com.xworkz.project.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EditController {

    @Autowired
    private SignUpService signUpService;

    EditController(){
        System.out.println("created constr for Edit Controller");
    }


}
