package com.soit23.enterprise;

import com.soit23.enterprise.entitiy.Faculty;
import com.soit23.enterprise.service.FacultyService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                return "faculties/list-faculties";

    }

    @GetMapping("/viewAddForm")
    public String viewAddForm(Model theModel){

        //Model attribute for the data binding
        Faculty theFaculty = new Faculty();
        theModel.addAttribute("faculty", theFaculty);
        return "faculties/faculty-form";
    }

    @GetMapping("/viewUpdateForm")
    public String viewUpdateForm(@RequestParam("facultyId") int theId, Model theModel){
        //Retrieve the faculty info from the service layer
        Faculty theFaculty = facultyService.findById(theId);

        //Pre-populate the form by setting the faculty as a model attribute
        theModel.addAttribute("faculty", theFaculty);

        //Redirect us to the faculty form
        return "faculties/faculty-form";
    }

    @PostMapping("/save")
    public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty){
        //Register the Faculty
        facultyService.save(theFaculty);

        //Block duplicate submission for accidental refresh
        return "redirect:/Faculties/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("facultyId") int theId){
        //Delete Faculty
        facultyService.deleteById(theId);

        //Return to Faculties Directory
        return "redirect:/Faculties/list";
    }

}
