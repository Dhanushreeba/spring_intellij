package com.xworkz.project.model.repo;

import com.xworkz.project.dto.SystemDto;

import java.util.List;

public interface SystemRepo {

    public boolean saveAndValidation(SystemDto dto);


}
