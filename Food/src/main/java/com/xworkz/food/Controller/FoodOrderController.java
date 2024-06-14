package com.xworkz.food.Controller;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.model.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class FoodOrderController {

    @Autowired
    private FoodService foodService;

    public FoodOrderController(){
        System.out.println("Creating thread for FoodOrderController");
    }

    @PostMapping("/order")
    public String display(@Valid FoodOrderDto dto, BindingResult bindingResult, Model model){

    if (bindingResult.hasErrors()){
        System.out.println("Dto has Inavlid Data");
        bindingResult
                .getAllErrors()
                .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
        model.addAttribute("errors",bindingResult.getAllErrors());
        model.addAttribute("dto",dto);

    }else{
        model.addAttribute("name","Thanks for your Order" +dto.getName());

        boolean save=this.foodService.save(dto);
        System.out.println("dto" +dto);
        if (save){
            System.out.println("Saved Successfully " +dto);
        }
        else {
            System.out.println("Not Saved Successfully " +dto);
            return "Food.jsp";
        }

    }
        System.out.println("creating Food Order Page/food");
        System.out.println("Food Data" +dto);
        return "Food.jsp";
    }

}
