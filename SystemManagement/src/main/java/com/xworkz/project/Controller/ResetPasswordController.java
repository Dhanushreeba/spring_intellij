package com.xworkz.project.controller;

import com.xworkz.project.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ResetPasswordController {

    @Autowired
    private SignUpService signUpService;

    ResetPasswordController() {
        System.out.println("created constr for ResetPasswordController");
    }

    @PostMapping("/reset")
    public String set(@RequestParam("email") String email, Model model) {
        // Generate and set password before saving
//        String generatedPassword = passwordGenerator.generatePassword(12);
//        dto.setPassword(generatedPassword);
//
//        model.addAttribute("msg", "new password Successfully generated " + dto.getEmail());
//        boolean save = this.signUpService.save(dto);
//        if (save) {
//            System.out.println("Details Saved Successfully " + dto);
//
//            // Send email with generated password
//            String subject = "Welcome to our Issue Management";
//            String body = "Hello " + dto.getEmail() + ",\n\nA new password has been generated for you: " + dto.getPassword();
//
//            signUpService.sendingEmail(email, subject, body);
//            return "WelcomePage";
//        } else {
//            System.out.println("Details Not Saved Successfully " + dto);
//            model.addAttribute("error", "Failed to save details");
//            return "ForgetPassword"; // Return the name of the forget password view
//        }
        return "";

    }


}
