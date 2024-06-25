package com.xworkz.people.Controller;


import com.xworkz.people.dto.PrimeMinisterDto;
import com.xworkz.people.dto.PrimeMinisterSearchDto;
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
public class PrimeMinisterController {

    @Autowired
    private PeopleService peopleService;

    public PrimeMinisterController(){
        System.out.println("creating constr for PrimeMinisterController");
        System.out.println("Created Search in PrimeMinisterController");
    }


    @PostMapping("/pm")
    public String display(@Valid PrimeMinisterDto pMDto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            System.out.println("Dto has Inavlid Data");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute("pMDto",pMDto);

        }else{
            model.addAttribute("name","Thanks for giving details" +pMDto.getName());

            boolean save=this.peopleService.save(pMDto);
            System.out.println("pMDto" +pMDto);
            if (save){
                System.out.println("PrimeMinisterController Saved Successfully " +pMDto);
            }
            else {
                System.out.println("PrimeMinisterController Not Saved Successfully " +pMDto);
                return "PrimeMinister.jsp";
            }

        }
        System.out.println("creating PrimeMinister Page/pm");
        System.out.println("PrimeMinister Data" +pMDto);
        return "PrimeMinister.jsp";
    }


    @GetMapping("/pmsearch")
    public String search(@Valid PrimeMinisterSearchDto pMSearchDto, Model model)
    {
        System.out.println("search method is running in searchController");
        List<PrimeMinisterDto> list=peopleService.searchAndValidate(pMSearchDto);
        if(!list.isEmpty())
        {
            System.out.println("search in PrimeMinisterController success"+pMSearchDto);
        }
        else {
            System.out.println("search in PrimeMinisterController not success"+pMSearchDto);
            return "PrimeMinisterSearch.jsp";

        }
        model.addAttribute("name",pMSearchDto.getName());
        model.addAttribute("name",list);
        return "PrimeMinisterSearch.jsp";
    }

    @GetMapping("/pm-edit")
    public String onEdit(@RequestParam int pk, Model model){

        System.out.println("running on edit in PrimeMinisterController for pk or id : "+pk);
        PrimeMinisterDto pMDto=peopleService.findId(pk);
        if (pMDto!=null){
            System.out.println("Search in controller Success :"+pMDto);
            model.addAttribute("pMDto",pMDto);
        }else{
            System.out.println("search in controller not success :");
        }
        return "PrimeMinister.jsp";
    }
}
