package com.xworkz.beans;

import BankFormDto.BirthDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class BirthCertificate {

    public BirthCertificate(){

            System.out.println("creating thread for BirthCertificate");
        }

        @PostMapping("/go")
        public String display(@Valid BirthDto dto, BindingResult bindingResult, Model model) {

            if (bindingResult.hasErrors()) {
                System.out.println("DTO has invalid data");
                bindingResult
                        .getAllErrors()
                        .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
                model.addAttribute("errors", bindingResult.getAllErrors());
                model.addAttribute("birthDto", dto);
            } else {
                model.addAttribute("name", "Birth Certificate applied successfully " + dto.getName());
            }

            System.out.println("creating BirthCertificate page/Birth");
            System.out.println("Birth Data :" + dto);
            return "BirthCerft.jsp";
        }

}
