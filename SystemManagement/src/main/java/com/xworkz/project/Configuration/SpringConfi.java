package com.xworkz.project.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.project")
@EnableWebMvc
@PropertySource("classpath:Application.properties")
public class SpringConfi {

    public SpringConfi(){
        System.out.println("created constr in SpringConfi");
    }

    public ViewResolver viewResolver(){

        System.out.println("Registering ViewResolver in SpringConfi");
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        return internalResourceViewResolver;
    }
}
