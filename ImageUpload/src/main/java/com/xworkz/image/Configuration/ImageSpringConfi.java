package com.xworkz.image.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.image")
@EnableWebMvc

public class ImageSpringConfi implements WebMvcConfigurer {

    public ImageSpringConfi(){
        System.out.println("Created constr ImageSpringConfi");
    }

//    public ViewResolver viewResolver(){
//        System.out.println("Registering viewResolver in ImageSpringConfi");
//        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        return  internalResourceViewResolver;
//    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(2097152); // 2 MB
        return new CommonsMultipartResolver();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        registry.viewResolver(resolver);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:src/main/webapp/uploads/");
//    }
}
