package com.xworkz.people.dto;


import javax.persistence.*;

@Entity
@Table(name = "country")
public class CountryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer population;

    private String capitalCity;

    private Integer noOfStates;

    public CountryDto(){
        System.out.println("constr for CountryDto");
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", capitalCity='" + capitalCity + '\'' +
                ", noOfStates=" + noOfStates +
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Integer getNoOfStates() {
        return noOfStates;
    }

    public void setNoOfStates(Integer noOfStates) {
        this.noOfStates = noOfStates;
    }
}
