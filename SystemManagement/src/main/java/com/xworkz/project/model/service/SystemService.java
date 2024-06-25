package com.xworkz.project.model.service;

import com.xworkz.project.dto.SystemDto;

import java.time.LocalDateTime;

public interface SystemService {

    public boolean save(SystemDto dto);

//    public LocalDateTime currentDateTime(SystemDto dto);

 //  public void setCurrentDateTime(SystemDto dto, String dateTimeStr, String format);

    void setAuditValues(SystemDto dto,String createdBy,LocalDateTime createdOn,String updatedBy,LocalDateTime updatedOn,boolean isActive);

}

