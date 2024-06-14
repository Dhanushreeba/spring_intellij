package com.xworkz.farmer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.xworkz.farmer")
//@PropertySource("classpath:Application.properties")
public class SpringPrimaryConfiguration {


        public  SpringPrimaryConfiguration()
        {
            System.out.println("No param for SpringPrimaryConfiguration");
        }
}
