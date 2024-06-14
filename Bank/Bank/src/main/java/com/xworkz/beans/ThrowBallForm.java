package com.xworkz.beans;

import BankFormDto.ThrowBallDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class ThrowBallForm {

    public ThrowBallForm(){

        System.out.println("constr of ThrowBallForm");
    }

    @PostMapping("/throw")
    public String run(@Valid ThrowBallDto dto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            System.out.println("DTO has invalid data");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute("throwBallDto",dto);
        }
        else{
            model.addAttribute("name","Thanks for Registring" +dto.getParticipantName());
        }

        System.out.println("creating ThrowBallDto page/Throwball");
        System.out.println("ThrowBallDto Data :" +dto);
        return "ThrowBall.jsp";
    }
}
