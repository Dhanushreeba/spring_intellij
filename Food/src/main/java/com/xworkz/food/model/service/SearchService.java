package com.xworkz.food.model.service;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.dto.SearchDto;

import java.util.List;

public interface SearchService {

    List<FoodOrderDto> searchAndValidate(SearchDto searchDto);
}
