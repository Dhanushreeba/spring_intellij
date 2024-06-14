package com.xworkz.farmer.MatrimonyDto;

import java.io.Serializable;

public class MatrimonyDto implements Serializable {

    private String name;  //the property name and name attribute value must be same then only spring gives values to dto


    private  int age; //name attribute is important in order to save data in server

    private String gender;

    private String qualification;

    private String martialStatus;

    private String religion;

    private String lookingFor;

    public  MatrimonyDto(){

        System.out.println("no param Constr for Matrimony");
    }

    @Override
    public String toString() {
        return "MatrimonyDto{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", qualification='" + qualification + '\'' +
                ",martialStatus='" + martialStatus + '\'' +
                ", religion='" + religion + '\'' +
                ", lookingFor='" + lookingFor + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }


}
