package com.xworkz.people.model.service;

import com.xworkz.people.dto.*;
import com.xworkz.people.model.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleRepo peopleRepo;


    @Override
    public boolean save(ContactDto dto) {
        System.out.println("method from PeopleServiceImpl class");

        boolean save=peopleRepo.saveAndValidation(dto);
        if (save){
            System.out.println("Repo save in Service successfully " +dto);
        }
        else {
            System.out.println("Repo Not save in service successfully" +dto);
        }

        return true;
    }

    @Override
    public List<ContactDto> searchAndValidate(ContactSearchDto searchDto) {

        System.out.println("Running searchAndValidate method");
        List<ContactDto> list=this.peopleRepo.search(searchDto);
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

    @Override
    public boolean save(CountryDto countryDto) {
        System.out.println("method from PeopleServiceImpl class");

        boolean save=peopleRepo.saveAndValidation(countryDto);
        if (save){
            System.out.println("Repo save in Service successfully " +countryDto);
        }
        else {
            System.out.println("Repo Not save in service successfully" +countryDto);
        }

        return true;
    }

    @Override
    public List<CountryDto> searchAndValidate(CountrySearchDto countrySearchDto) {
        System.out.println("Running searchAndValidate method");
        List<CountryDto> list=this.peopleRepo.search(countrySearchDto);
        if(!list.isEmpty())
        {
            System.out.println("searched resulted  in dtos"+countrySearchDto);
            return  list;
        }
        else {
            System.out.println(" searched resulted in empty list in service"+countrySearchDto);
        }

        return Collections.emptyList();
    }

    @Override
    public boolean save(PrimeMinisterDto pMDto) {
        System.out.println("method from PeopleServiceImpl class");

        boolean save=peopleRepo.saveAndValidation(pMDto);
        if (save){
            System.out.println("Repo  save in Service successfully " +pMDto);
        }
        else {
            System.out.println("Repo  Not save in service successfully" +pMDto);
        }

        return true;
    }

    @Override
    public List<PrimeMinisterDto> searchAndValidate(PrimeMinisterSearchDto pMSearchDto) {
        System.out.println("Running searchAndValidate method");
        List<PrimeMinisterDto> list=this.peopleRepo.search(pMSearchDto);
        if(!list.isEmpty())
        {
            System.out.println("searched resulted  in dtos"+pMSearchDto);
            return  list;
        }
        else {
            System.out.println(" searched resulted in empty list in service"+pMSearchDto);
        }

        return Collections.emptyList();
    }

    @Override
    public ContactDto findById(int id) {
        System.out.println("running findById method in peopleServiceImpl of ContactServiceImpl.");
        ContactDto result=peopleRepo.findById(id);
        if (result!=null){
            System.out.println("searched result in service contact");
            return result;
        }
        else{
            System.out.println("Not searched result in service contact");
        }
        return PeopleService.super.findById(id);
    }
//country edit in service
    @Override
    public CountryDto findByServiceId(int id){
        System.out.println("running findByServiceId method in peopleServiceImpl of CountryServiceImpl");
        CountryDto result=peopleRepo.findByServiceId(id);
        if (result!=null){
            System.out.println("Searched result in service country");
            return result;
        }
        else {
            System.out.println("Not Searched result in service country");
        }
        return PeopleService.super.findByServiceId(id);
    }

    @Override
    public PrimeMinisterDto findId(int id) {
        System.out.println("running findById method in peopleServiceImpl of PrimeMinisterServiceImpl.");
        PrimeMinisterDto result=peopleRepo.findId(id);
        if (result!=null){
            System.out.println("searched result in service PrimeMinister");
            return result;
        }
        else{
            System.out.println("Not searched result in service PrimeMinister");
        }

        return PeopleService.super.findId(id);
    }

    //delete


    @Override
    public ContactDto deleteById(int id) {
        System.out.println("running deleteById method in peopleServiceImpl of ContactServiceImpl.");
        ContactDto result=peopleRepo.deleteById(id);
        if (result!=null){
            System.out.println("searched result in service ContactDto");
            return result;
        }else {
            System.out.println("Not searched result for delete in service ContactDto ");
        }
        return PeopleService.super.deleteById(id);

    }
}
