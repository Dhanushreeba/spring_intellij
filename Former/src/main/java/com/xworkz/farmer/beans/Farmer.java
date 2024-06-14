package com.xworkz.farmer.beans;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping
public class Farmer {

   public Farmer(){

        System.out.println("no param constr of Farmer");
    }
    @PostMapping("/walk")
    String run(){
        System.out.println("run method in Farmer");
        return "index.jsp";
    }


}
