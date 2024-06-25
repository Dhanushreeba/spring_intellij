package com.xworkz.project.Controller;

import com.xworkz.project.dto.SystemDto;
import com.xworkz.project.model.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SystemController {

    @Autowired
    private SystemService systemService;

    public SystemController(){
        System.out.println("created constr for SystemController");
    }

    @PostMapping("/signup")
    public String display(@Valid SystemDto dto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("Dto has invalid data in systemController");
            bindingResult
                    .getAllErrors()
                    .forEach(dtoError -> System.out.println(dtoError.getDefaultMessage()));
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("dto", dto);
        } else {
            model.addAttribute("name", "SignUp Successfull" + dto.getFirstName());
            boolean save = this.systemService.save(dto);
            System.out.println("dto" + dto);
            if (save) {
                System.out.println("Details Saved Successfully " + dto);
            } else {
                System.out.println(" Details Not Saved Successfully " + dto);
                return "SystemManagement.jsp";
            }

        }
        System.out.println("creating SignUp page/systemManagement");
        System.out.println("SystemManagement Data" + dto);
        return "SystemManagement.jsp";
    }
}
