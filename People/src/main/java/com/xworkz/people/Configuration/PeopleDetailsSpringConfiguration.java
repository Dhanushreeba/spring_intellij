package com.xworkz.people.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.xworkz.people")
@EnableWebMvc
@PropertySource("classpath:Application.properties")
public class PeopleDetailsSpringConfiguration  {

    public PeopleDetailsSpringConfiguration(){
        System.out.println("created constr in PeopleDetailsSpringConfiguration");
    }

    public ViewResolver viewResolver(){

        System.out.println("Registering ViewResolver in PeopleDetailsSpringConfiguration");
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        return internalResourceViewResolver;
    }

}
