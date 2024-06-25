package com.xworkz.people.Controller;


import com.xworkz.people.dto.CountryDto;
import com.xworkz.people.dto.CountrySearchDto;
import com.xworkz.people.model.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CountryController {

    @Autowired
    private PeopleService peopleService;

    public CountryController(){
        System.out.println("creating constr for CountryController");
        System.out.println("Created Search in CountryController");
    }


    @PostMapping("/country")
    public String display(@Valid CountryDto countryDto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            System.out.println("Dto has Inavlid Data in Country");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute("countryDto",countryDto);

        }else{
            model.addAttribute("msg","Thanks for giving details" +countryDto.getName());

            boolean save=this.peopleService.save(countryDto);
            System.out.println("dto" +countryDto);
            if (save){
                System.out.println("Country Saved Successfully " +countryDto);
            }
            else {
                System.out.println("Country Not Saved Successfully " +countryDto);
                return "Country.jsp";
            }

        }
        System.out.println("creating Country  Page/country");
        System.out.println("Country Data" +countryDto);
        return "Country.jsp";
    }


    @GetMapping("/csearch")
    public String search(@Valid CountrySearchDto countrySearchDto, Model model)
    {
        System.out.println("search method is running in searchController");
        List<CountryDto> list=peopleService.searchAndValidate(countrySearchDto);
        if(!list.isEmpty())
        {
            System.out.println("search in controller success"+countrySearchDto);
        }
        else {
            System.out.println("search in controller not success"+countrySearchDto);
            return "CountrySearch.jsp";

        }
        model.addAttribute("state",countrySearchDto.getCapitalCity());
        model.addAttribute("listOfCountry",list);
        return "CountrySearch.jsp";
    }

    @GetMapping("/country-edit")
    public String onEdit(@RequestParam int pk,Model model){
        System.out.println("running on edit in CountryController for pk or id : "+pk);
        CountryDto countryDto=peopleService.findByServiceId(pk);
        if (countryDto!=null){
            System.out.println("Search in CountryController success :"+countryDto);
            model.addAttribute("countryDto",countryDto);


        }else{
            System.out.println("search in controller not success :");
        }
        return "Country.jsp";
    }
}
