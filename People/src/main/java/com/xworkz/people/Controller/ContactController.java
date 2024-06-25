package com.xworkz.people.Controller;


import com.xworkz.people.dto.ContactDto;
import com.xworkz.people.dto.ContactSearchDto;
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
public class ContactController {

    @Autowired
    private PeopleService peopleService;

    public ContactController(){
        System.out.println("creating constr for ContactController");
        System.out.println("Created SearchController for Contact");
    }


    @PostMapping("/contact")
    public String display(@Valid ContactDto dto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            System.out.println("Dto has Inavlid Data in contact");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError-> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute("dto",dto);

        }else{
            model.addAttribute("name","Thanks for giving details" +dto.getName());

            boolean save=this.peopleService.save(dto);
            System.out.println("dto" +dto);
            if (save){
                System.out.println("Contact Saved Successfully " +dto);
            }
            else {
                System.out.println(" Contact Not Saved Successfully " +dto);
                return "Contact.jsp";
            }

        }
        System.out.println("creating Contact  Page/contact");
        System.out.println("Contact Data" +dto);
        return "Contact.jsp";
    }


    @GetMapping("/search")
    public String search(@Valid ContactSearchDto searchDto, Model model)
    {
        System.out.println("search method is running in ContactController");
        List<ContactDto> list=peopleService.searchAndValidate(searchDto);
        if(!list.isEmpty())
        {
            System.out.println("search in ContactController success"+searchDto);
        }
        else {
            System.out.println("search in ContactController not success"+searchDto);
            return "ContactSearch.jsp";

        }
        model.addAttribute("name",searchDto.getName());
        model.addAttribute("listOfName",list);
        return "ContactSearch.jsp";
    }

    //edit
    @GetMapping("/contact-edit")
    public String onEdit(@RequestParam int pk,Model model){

        System.out.println("running on edit in contactController for pk or id : "+pk);
        ContactDto dto=peopleService.findById(pk);
        if (dto!=null){
            System.out.println("Search in controller for edit Success :"+dto);
            model.addAttribute("dto",dto);
        }else{
            System.out.println("search in controller for edit not success :");
        }
        return "Contact.jsp";
    }

    //delete
    @GetMapping("/contact-delete")
    public String onDelete(@RequestParam int pk,Model model){
        System.out.println("running onDelete in ContactController for pk :"+pk);
        ContactDto dto=peopleService.deleteById(pk);
        if (dto!=null){
            System.out.println("Search in controller for delete success :"+pk);
            model.addAttribute("dto",dto);
        }else{
            System.out.println("search in controller for delete not success :"+pk);
        }
        return "Contact.jsp";
    }
}
