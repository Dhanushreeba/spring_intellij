package com.xworkz.beans;

import BankFormDto.AdharDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class AdharForm {


        public AdharForm(){

            System.out.println("creating thread for AdharForm");
        }

        @PostMapping("/card")
        public String display(@Valid AdharDto dto, BindingResult bindingResult, Model model) {

            if (bindingResult.hasErrors()) {
                System.out.println("DTO has invalid data");
                bindingResult
                        .getAllErrors()
                        .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
                model.addAttribute("errors", bindingResult.getAllErrors());
                model.addAttribute("adharDto", dto);
            } else {
                model.addAttribute("name", "AdharCard applied successfully " + dto.getName());
            }

            System.out.println("creating Adhar page/adhar");
            System.out.println("Adhar Data :" + dto);
            return "Adhar.jsp";
        }

    }
