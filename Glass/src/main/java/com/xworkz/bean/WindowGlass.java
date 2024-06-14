package com.xworkz.bean;

import com.xworkz.DrinkingGlass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WindowGlass {

    @Autowired
    private String color;

    @Autowired
    private String size;

    @Autowired
    private String ownerName;

    @Autowired
    private String place;

    public WindowGlass(){
        System.out.println("running Window glass ");
    }


    public WindowGlass(DrinkingGlass drinkingGlass){

        System.out.println("constr injection");

    }

}
