package com.xworkz.people.dto;

public class PrimeMinisterSearchDto {

    private Integer id;

    private String name;

    public PrimeMinisterSearchDto(){
        System.out.println("created PrimeMinisterSearchDto");
    }

    @Override
    public String toString() {
        return "PrimeMinisterSearchDto{" +
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
