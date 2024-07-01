package com.xworkz.project.Controller;


import com.xworkz.project.dto.SystemDto;
import com.xworkz.project.model.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
//
//    @Autowired
//    private SystemService systemService;
//
//
//    public EmailController(){
//        System.out.println("running contr for  EmailController");
//    }
//
//    @GetMapping("/signup")
//    public boolean checkEmail(@RequestParam("email") String email) {
//        return systemService.findByEmail(email) != null;
//    }


//    @GetMapping("/validateEmail/check/{check}")
//    public String validateEmail(@PathVariable String email) {
//        SystemDto dto = systemService.existsByEmail(email);
//        return dto != null ? "Email is already Exist" : "";
//    }

//    @GetMapping("/validateContactNumber/{contactNumber}")
//    public String validateContactNumber(@PathVariable Long contactNumber) {
//        {
//            SystemDto existingContactNumber = systemService.findByContactNumber(contactNumber);
//            return existingContactNumber != null ? "Contact number already exists" : "";
//        }}

}
