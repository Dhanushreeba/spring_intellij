package com.xworkz.food.model.repository;

import com.xworkz.food.dto.FoodOrderDto;
import org.springframework.stereotype.Repository;

@Repository
public class FoodRepoImpl implements FoodRepo{

    public FoodRepoImpl(){
        System.out.println("Constr of FoodRepoImpl class");
    }

    @Override
    public boolean saveAndValidation(FoodOrderDto dto) {

        System.out.println("method from foodRepoImpl class");
        return true;
    }
}
