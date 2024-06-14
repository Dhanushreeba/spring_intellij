package com.xworkz.beans;

import BankFormDto.DressOrderDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class DressOrderForm {

        public DressOrderForm(){

            System.out.println("creating thread for DressOrderForm");
        }

        @PostMapping("/order")
        public String display(@Valid DressOrderDto dto, BindingResult bindingResult, Model model) {

            if (bindingResult.hasErrors()) {
                System.out.println("DTO has invalid data");
                bindingResult
                        .getAllErrors()
                        .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
                model.addAttribute("errors", bindingResult.getAllErrors());
                model.addAttribute("dressOrderDto", dto);
            } else {
                model.addAttribute("name", "Order Placed successfully " + dto.getName());
            }

            System.out.println("creating DressOrderDto page/DressOrder");
            System.out.println("DressOrder Data :" + dto);
            return "DressOrder.jsp";
        }

    }
