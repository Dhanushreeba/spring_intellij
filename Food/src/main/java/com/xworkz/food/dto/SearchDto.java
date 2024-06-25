package com.xworkz.food.dto;


public class SearchDto {

    public  SearchDto()
    {
        System.out.println("Created SearchDto");
    }

    private int id;

    private  String name;

    @Override
    public String toString() {
        return "SearchDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
