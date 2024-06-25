package com.xworkz.image.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class ImageWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public ImageWebInit(){
        System.out.println("created constr ImageWebInit");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("created getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("created getServletConfigClasses");
        return new Class[]{ImageSpringConfi.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("created getServletMappings");
        return new String[ ]{"/"};
    }

//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp", 2097152, 4194304, 0));
//    }
}
