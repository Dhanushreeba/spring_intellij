package com.xworkz.beans;


import BankFormDto.HomeDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class HomeRegistration {

    public HomeRegistration(){

        System.out.println("creating thread for HomeRegistration");
    }

    @PostMapping("/walk")
    public String display(@Valid HomeDto dto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("DTO has invalid data");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("homeDto", dto);
        } else {
            model.addAttribute("name", "Registration Successfull" + dto.getFullName());
        }

        System.out.println("creating HomeRegistration page/Home");
        System.out.println("Home Data :" + dto);
        return "Home.jsp";
    }

}
