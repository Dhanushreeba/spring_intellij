package com.xworkz.project.model.service;

import com.xworkz.project.dto.SystemDto;
import com.xworkz.project.model.repo.SystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class SystemServiceImpl implements SystemService{

    @Autowired
    private SystemRepo systemRepo;

    public SystemServiceImpl(){
        System.out.println("running constr for SystemServiceImpl class");
    }

    @Override
    public boolean save(SystemDto dto) {

        System.out.println("save method from SystemServiceImpl");

        setAuditValues(dto,"aishu",LocalDateTime.now(),"NA",null,true);

        boolean save=systemRepo.saveAndValidation(dto);
        if (save){
            System.out.println("Repo save in search successfull "+dto);
        }else{
            System.out.println("Repo save in search not successfull "+dto);
        }
        return true;
    }

    @Override
    public void setAuditValues(SystemDto dto, String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn, boolean isActive) {
        dto.setCreatedBy(createdBy);
        dto.setCreatedOn(createdOn);
        dto.setUpdatedBy(updatedBy);
        dto.setActive(isActive);
    }


}
