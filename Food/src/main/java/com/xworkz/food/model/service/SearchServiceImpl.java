package com.xworkz.food.model.service;

import com.xworkz.food.dto.FoodOrderDto;
import com.xworkz.food.dto.SearchDto;
import com.xworkz.food.model.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchRepo searchRepo;

    @Override
    public List<FoodOrderDto> searchAndValidate(SearchDto searchDto) {

        System.out.println("Running searchAndValidate method");
        List<FoodOrderDto> list=this.searchRepo.search(searchDto);
        if(!list.isEmpty())
        {
            System.out.println("searched resulted  in dtos"+searchDto);
            return  list;
        }
        else {
            System.out.println(" searched resulted in empty list in service"+searchDto);
        }

        return Collections.emptyList();
    }
}
