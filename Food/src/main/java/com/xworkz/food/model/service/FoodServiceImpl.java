package com.xworkz.food.model.service;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.model.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepo foodRepo;

    public FoodServiceImpl(){

        System.out.println("constr of FoodServiceImpl");
    }

    @Override
    public boolean save(FoodOrderDto dto) {

        System.out.println("method from FoodOrderImpl class");

        boolean save=foodRepo.saveAndValidation(dto);
        if (save){
            System.out.println("Repo save in Service successfully " +dto);
        }
        else {
            System.out.println("Repo Not save in service successfully" +dto);
        }

        return true;
    }
}
