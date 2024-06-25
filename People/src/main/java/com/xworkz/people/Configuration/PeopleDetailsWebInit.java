package com.xworkz.people.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PeopleDetailsWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

    public PeopleDetailsWebInit(){
        System.out.println("no param constr for PeopleDetailsWebInit");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("created getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("created getServletConfigClasses");
        return new Class[]{PeopleDetailsSpringConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("created getServletMappings");
        return new String[]{"/contact","/search","/contact-edit","/contact-delete","/country","/csearch","/country-edit","/pm","/pmsearch","/pm-edit"};
    }


}
