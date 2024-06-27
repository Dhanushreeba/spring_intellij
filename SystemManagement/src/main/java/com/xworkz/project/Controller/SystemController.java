package com.xworkz.project.Controller;

import com.xworkz.project.dto.SystemDto;
import com.xworkz.project.model.service.SystemService;
import com.xworkz.project.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static java.awt.SystemColor.text;

@Controller
@RequestMapping("/")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private PasswordGenerator passwordGenerator;



    public SystemController() {
        System.out.println("Created constructor for SystemController");
    }

    @PostMapping("/signup")
    public String display(@Valid SystemDto dto, BindingResult bindingResult, Model model, @RequestParam("email") String email) {
        // Generate and set password before validation
        String generatedPassword =passwordGenerator.generatePassword(12);
        dto.setPassword(generatedPassword);

        if (bindingResult.hasErrors()) {
            System.out.println("Dto has invalid data in systemController");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("dto", dto);
            return "SignUp";
        } else {
            model.addAttribute("name", "SignUp Successful " + dto.getFirstName());
            boolean save = this.systemService.save(dto);
            System.out.println("dto" + dto);
            if (save) {
                System.out.println("Details Saved Successfully " + dto);

                //send email with generated password
                String subject="Welcome to our Issue Management";

                String body="Hi Hello" + dto.getFirstName() + ",\n\n your registration is successfull. your password is" +dto.getPassword();

                systemService.sendingEmail(email,subject, body);

            } else {
                System.out.println("Details Not Saved Successfully " + dto);
                return "Login";
            }
        }
        System.out.println("Creating SignUp page/SignUp");
        System.out.println("SignUp Data :" + dto);
        return "Login";
    }

    //LoginPage
//    @GetMapping("/login")
//    public String loginPage(Model model) {
//        model.addAttribute("dto", new SystemDto());
//        return "Login";
//    }

    @PostMapping("login")
    public String login( String email, String password, Model model) {
        System.out.println("running login method...");
        SystemDto dto1=systemService.findByPassword(email, password);
        if (dto1!=null){
            //System.out.println("login success");
            model.addAttribute("msg","Login successful.Welcome, "+dto1.getFirstName());
            model.addAttribute("isLocked", false); // Account is not locked
            return  "WelcomePage";//change to welcome page
        }

        else {
                //acc lock after 3 attempts
                systemService.incrementFailedAttempts(email);
                int failedAttempts = systemService.getFailedAttempts(email);
                System.out.println("Failed attempts for " + email + ": " + failedAttempts);
                if (failedAttempts > 3) {
                    model.addAttribute("error", "Your account is locked due to too many failed attempts.");
                    model.addAttribute("isLocked", true); // Add attribute to indicate the account is locked
                } else {
                    model.addAttribute("error", "Invalid email id and password. Attempts: " + failedAttempts);
                    model.addAttribute("isLocked", false); // Add attribute to indicate the account is not locked

                }
                return "Login"; // Return to login page
            }

            //System.out.println("login not success");
           // model.addAttribute("error","Invalid email or password. Please try again");
          //  return "Login";
        }


//
//    @PostMapping()
//    public String sendEmail(String to, String subject, String text, Model model) {
//        try {
//            systemService.sendingEmail(to, subject, text);
//            model.addAttribute("msg", "Email sent successfully!");
//        } catch (Exception e) {
//            model.addAttribute("error", "Error sending email: " + e.getMessage());
//        }
//        return "email.jsp";
//    }

}