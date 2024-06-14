package com.xworkz.food.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FoodWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("created getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("created getServletConfigClasses");
        return new Class[]{FoodSpringConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("created getServletMappings");
        return new String[]{"/order"};
    }
}
