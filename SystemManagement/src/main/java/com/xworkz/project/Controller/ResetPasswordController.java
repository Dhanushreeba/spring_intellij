package com.xworkz.project.controller;

import com.xworkz.project.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ResetPasswordController {

    @Autowired
    private SignUpService signUpService;


    ResetPasswordController() {
        System.out.println("created constr for ResetPasswordController");
    }

//    @PostMapping("/reset")
//    public String passwordReset(RedirectAttributes redirectAttributes, String email, String oldPassword, String newPassword, String confirmPassword) {
//
//        boolean resetSuccessful = signUpService.resetPassword(email, oldPassword, newPassword, confirmPassword);
//        if (resetSuccessful) {
//            System.out.println("Password reset Successful: " + resetSuccessful);
//            redirectAttributes.addFlashAttribute("passwordResetMessage", "Password reset successful");
//        } else {
//            redirectAttributes.addFlashAttribute("passwordResetError", "Failed to reset password. Please check your password");
//        }
//
//        return "reset";
//    }
//
//    @RequestMapping("reset")
//    public String showResetPasswordPage(Model model) {
//        return "ResetPassword";
//    }

    @PostMapping("/reset")
    public String passwordReset(Model model, String email, String oldPassword, String newPassword, String confirmPassword) {

        boolean resetSuccessful = signUpService.resetPassword(email, oldPassword, newPassword, confirmPassword);
        if (resetSuccessful) {
            System.out.println("Password reset Successful:" + resetSuccessful);
            model.addAttribute("passwordResetMessage", "Password reset successful");

        } else {
            model.addAttribute("passwordResetError", "Failed to reset password.Please check your password");
        }

        return "SignIn";
    }
    // return "ResetPassword";
}


