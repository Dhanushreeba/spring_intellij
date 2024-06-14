package com.xworkz.beans;

import BankFormDto.BankDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class BankForm {

    public BankForm(){

        System.out.println("constr of Bank");
    }

    @PostMapping("/open")
    public String run(@Valid BankDto bankDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            System.out.println("DTO has invalid data");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute("bankDto",bankDto);
        }
        else{
            model.addAttribute("name","Thanks for Registring" +bankDto.getName());
        }

        System.out.println("creating matrimony page/Marriage");
        System.out.println("Bank Data :" +bankDto);
        return "Bank.jsp";
    }
}
