package com.sales_portal.demo.controllers;

import com.sales_portal.demo.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@AllArgsConstructor
public class ProjectsController {
    private ProjectService projectService;


    @RequestMapping({"mvc/projects/showAll"})
    public ModelAndView showAllProjects(){
        ModelAndView mv = new ModelAndView("showProjectList");
        mv.addObject("project",projectService.getAllProjects());
        return mv;
    }

    @GetMapping("mvc/project/insert")
    public String insertProject(){
        return "insertProject";
    }

    @PostMapping("mvc/project/insert")
    public ModelAndView insertProject(String company_name, String PO_number, Double amount,
                                      String project_status, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE , pattern = "yyyy-MM-dd" ) Date start_date, @DateTimeFormat(pattern = "yyyy-MM-dd") Date delivery_date, String contact_person){
       projectService.insertProject(company_name,PO_number,amount,project_status,start_date,delivery_date,contact_person);
        return showAllProjects();

    }

}
