package com.xworkz.springFramework;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

@Component
public class Cover {

    @Bean
    public String write(){
        System.out.println("this is write method in write");
        return "Do not use plastic cover";
    }

    @Bean
    public char[] read(){
        System.out.println("this is Read method in char[]");
        return new char[]{'a','e','i','o','u'};
    }

    @Bean
    public LinkedList<String> run(){
        System.out.println("this is run method in linkedList");
        return  new LinkedList<>();
    }

    @Bean
    public Map walk(){
        System.out.println("this is walk method in map");
        return  new HashMap();
    }

    @Bean
    public Properties get(){
        System.out.println("this is get method in properties");
        return new Properties();
    }

    @Bean
    public Temple god(){
        System.out.println("this is god method in Temple");
        return new Temple();
    }

    @Bean
    public Spoon steel(){
        System.out.println("this is steel method in Spoon");
        return  new Spoon();
    }

    @Bean
    public Snake bite(){
        System.out.println("this is bite method in Snake");
        return  new Snake();
    }

    @Bean
    public Mug tea(){
        System.out.println("this is tea method in Mug");
        return  new Mug();
    }

}
