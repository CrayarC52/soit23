package com.soit23.enterprise;

import com.soit23.enterprise.entitiy.Faculty;
import com.soit23.enterprise.service.FacultyService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {

    public FacultyService facultyService;
    public FacultyController(FacultyService theFacultyService){
        facultyService = theFacultyService;


    }


    //Mapping for list
    @GetMapping("/list")
    public String listFaculties(Model theModel){
        //Retrieve faculties from the Database
        List<Faculty> theFaculties = facultyService.findAll();

        //Add Faculties to the Spring Model
        theModel.addAttribute("faculties", theFaculties);
                return "List-faculties";

    }

}
