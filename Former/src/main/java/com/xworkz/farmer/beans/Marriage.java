package com.xworkz.farmer.beans;

import com.xworkz.farmer.MatrimonyDto.ContactDto;
import com.xworkz.farmer.MatrimonyDto.MatrimonyDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping
public class Marriage {

    public Marriage(){

        System.out.println("constr of Marriage");
    }

    @PostMapping("/marry")
    public String display(MatrimonyDto matrimonyDto){

        System.out.println("creating matrimony page/Marriage");
        System.out.println("matrimony Data :" +matrimonyDto);
        return "MatrimonyRegister.jsp";
    }

    @PostMapping("/contact")
    public String run(ContactDto contactDto){

        System.out.println("creating matrimony page/Contact");
        System.out.println("Contact Data :" +contactDto);
        return "Contact.jsp";
    }
}
