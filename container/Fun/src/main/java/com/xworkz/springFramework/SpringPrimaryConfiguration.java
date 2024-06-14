package com.xworkz.springFramework;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.springFramework")
public class SpringPrimaryConfiguration {

    public  SpringPrimaryConfiguration()
    {

        System.out.println("No param for SpringPrimaryConfiguration");
    }
}
