package com.xworkz.beans;


import BankFormDto.TeacherDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class TeacherForm {

        public TeacherForm(){

            System.out.println("constr of TeacherForm");
        }

        @PostMapping("/run")
        public String run(@Valid TeacherDto dto, BindingResult bindingResult, Model model){

            if(bindingResult.hasErrors()){
                System.out.println("DTO has invalid data");
                bindingResult
                        .getAllErrors()
                        .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
                model.addAttribute("errors",bindingResult.getAllErrors());
                model.addAttribute("dto",dto);
            }
            else{
                model.addAttribute("name","Thanks for Registring" +dto.getName());
            }

            System.out.println("creating matrimony page/Marriage");
            System.out.println("Teacher Data :" +dto);
            return "Teacher.jsp";
        }


    public static class DressOrderForm {
    }
}
