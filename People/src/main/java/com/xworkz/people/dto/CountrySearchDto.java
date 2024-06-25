package com.xworkz.people.dto;

public class CountrySearchDto {



    private String capitalCity;

    public CountrySearchDto(){
        System.out.println("created CountrySearchDto");
    }

    @Override
    public String toString() {
        return "CountrySearchDto{" +

                ", capitalCity='" + capitalCity + '\'' +
                '}';
    }


    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
