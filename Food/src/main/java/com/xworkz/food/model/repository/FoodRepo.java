package com.xworkz.food.model.repository;

import com.xworkz.food.dto.FoodOrderDto;

public interface FoodRepo {

    public boolean saveAndValidation(FoodOrderDto dto);
}
