package com.xworkz.farmer.beans;

import java.io.Serializable;

public class Bank implements Serializable {

    private String name;
    private String age;
    private Long phone;

   public  Bank(){
       System.out.println("no param constr for Bank");
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
