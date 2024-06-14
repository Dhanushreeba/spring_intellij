package com.xworkz.configuartion;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    public SpringWebInit() {
        System.out.println("no param constr of SpringWebInit");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("running getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("running getServletConfigClasses");
        return new Class[]{SpringPrimaryConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("running getServletMappings");
        return new String[0];
    }

}