package com.xworkz.food.model.repository;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.dto.SearchDto;

import java.util.List;

public interface SearchRepo {

    List<FoodOrderDto> search(SearchDto searchDto);
}
