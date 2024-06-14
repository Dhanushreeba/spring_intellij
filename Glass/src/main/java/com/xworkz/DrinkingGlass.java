package com.xworkz;

import com.xworkz.bean.WindowGlass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrinkingGlass {

    @Autowired
    private  String height;

    @Autowired
    private  String design;

    @Autowired
    private String weight;

    public DrinkingGlass(){

        System.out.println("running DrinkingGlass no param constr");
    }
}
