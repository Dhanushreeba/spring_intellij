package com.xworkz.beans;


import BankFormDto.WeddingMakeupDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class WeddingMakeup {

    public WeddingMakeup(){

            System.out.println("constr of WeddingMakeup");
        }

        @PostMapping("/makeup")
        public String run(@Valid WeddingMakeupDto dto, BindingResult bindingResult, Model model){

            if(bindingResult.hasErrors()){
                System.out.println("DTO has invalid data");
                bindingResult
                        .getAllErrors()
                        .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
                model.addAttribute("errors",bindingResult.getAllErrors());
                model.addAttribute("weddingMakeupDto",dto);
            }
            else{
                model.addAttribute("name","Thanks for Registring" +dto.getName());
            }

            System.out.println("creating ThrowBallDto page/Throwball");
            System.out.println("ThrowBallDto Data :" +dto);
            return "WeddingMakeup.jsp";
        }
}
