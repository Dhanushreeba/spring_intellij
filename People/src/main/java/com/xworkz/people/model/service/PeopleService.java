package com.xworkz.people.model.service;

import com.xworkz.people.dto.*;

import java.util.List;

public interface PeopleService {

    public boolean save(ContactDto dto);

    List<ContactDto> searchAndValidate(ContactSearchDto searchDto);

    public boolean save(CountryDto countryDto);

    List<CountryDto> searchAndValidate(CountrySearchDto countrySearchDto);

    public boolean save(PrimeMinisterDto pMDto);

    List<PrimeMinisterDto> searchAndValidate(PrimeMinisterSearchDto pMSearchDto);

    //Edit

     default ContactDto findById(int id){

        return null;
    }

    default CountryDto findByServiceId(int id){

        return null;
    }

    default PrimeMinisterDto findId(int id){

        return null;
    }


    // delete

    default ContactDto deleteById(int id){

        return null;
    }
}
