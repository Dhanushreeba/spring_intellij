package com.xworkz.farmer.MatrimonyDto;

import java.io.Serializable;

public class ContactDto implements Serializable {

    private String name;

    private String email;

    private int mobile;

    private  String comment;

    public ContactDto(){

        System.out.println("no param Constr for Contact");
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
