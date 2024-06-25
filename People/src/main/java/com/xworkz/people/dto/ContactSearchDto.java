package com.xworkz.people.dto;

public class ContactSearchDto {

    public ContactSearchDto()
    {
        System.out.println("Created ContactSearchDto");
    }


    private Integer id;

    private  String name;

    @Override
    public String toString() {
        return "ContactSearchDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
