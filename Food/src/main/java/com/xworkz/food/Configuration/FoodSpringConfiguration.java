package com.xworkz.food.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.food")
@EnableWebMvc
@PropertySource("classpath:Application.properties")
public class FoodSpringConfiguration {

    public FoodSpringConfiguration(){

        System.out.println("created FoodSpringConfiguration");
    }
}
