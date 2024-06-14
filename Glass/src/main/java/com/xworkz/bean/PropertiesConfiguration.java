package com.xworkz.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;


@Configuration

public class PropertiesConfiguration {

    @Value("${host}")
    private String host;

    @Value("${portNumber}")
    private String portNumber;

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    public PropertiesConfiguration(){

        System.out.println("creating Constr for Properties");
    }

    @Bean
    public void run(){
        System.out.println("********************");
        System.out.println(this.host);
        System.out.println(this.portNumber);
        System.out.println(this.userName);
        System.out.println(this.password);
    }

}
