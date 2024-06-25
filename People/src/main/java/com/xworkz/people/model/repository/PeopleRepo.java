package com.xworkz.people.model.repository;

import com.xworkz.people.dto.*;

import java.util.List;

public interface PeopleRepo {

    public boolean saveAndValidation(ContactDto dto);

    List<ContactDto> search(ContactSearchDto searchDto);

    public boolean saveAndValidation(CountryDto countryDto);

    List<CountryDto> search(CountrySearchDto countrySearchDto);

    public boolean saveAndValidation(PrimeMinisterDto primeMinisterDto);

    List<PrimeMinisterDto> search(PrimeMinisterSearchDto pMSearchDto);


    //Editing
    //Contact

    default ContactDto findById(int id){

        return null;
    }
//country
    default CountryDto findByServiceId(int id){

        return null;
    }

   //pm
    default PrimeMinisterDto findId(int id){

        return null;
    }

    //Delete
    //Contact
    default ContactDto deleteById(int id){

        return null;
    }
}
