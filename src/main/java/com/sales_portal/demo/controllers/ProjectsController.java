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
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ProjectsController {
    private ProjectService projectService;


    @RequestMapping("mvc/project/showAll")
    public ModelAndView showAllProjects(){
        ModelAndView mv = new ModelAndView("showProjectList");
        mv.addObject("project",projectService.getAllProjects());
        mv.addObject("search", "");
        return mv;
    }

    @PostMapping("mvc/project/showAll")
    public ModelAndView search(String search){
        ModelAndView mv = new ModelAndView("showProjectList");
        mv.addObject("project", projectService.listCompanyByName(search));
        mv.addObject("search", search);
        return mv;
    }

    @GetMapping("mvc/project/insert")
    public String insertProject(){
        return "insertProject";
    }

    @PostMapping("mvc/project/insert")
    public ModelAndView insertProject(String company_name, String PO_number, Double amount,
                                      String project_status, java.sql.Date start_date,java.sql.Date delivery_date, String contact_person){
       projectService.insertProject(company_name,PO_number,amount,project_status,start_date,delivery_date,contact_person);
        return showAllProjects();

    }

    @RequestMapping("mvc/project/{id}/delete")
    public ModelAndView deleteProject(@PathVariable Integer id){
        projectService.deleteProject(id);
        return showAllProjects();

    }

    @GetMapping("mvc/project/{id}/modify")

    public ModelAndView modifyProject(@PathVariable Integer id, Optional<String> companyName,
                                      Optional<String> PO_number, Optional<Double> amount,
                                      Optional<String>project_status, java.sql.Date start_date,
                                      java.sql.Date delivery_date, Optional<String>contact_person){
        ModelAndView mv= new ModelAndView("modifyProject");
        mv.addObject("project",projectService.getProject(id));
        projectService.modifyProject(id,companyName,PO_number,amount,project_status,start_date,delivery_date,contact_person);

        return mv;

    }

    @PostMapping("mvc/project/{id}/modify")
    public ModelAndView modifyProjectDetails(@PathVariable Integer id, Optional<String> companyName,
                                             Optional<String> PO_number, Optional<Double> amount,
                                             Optional<String>project_status, java.sql.Date start_date,
                                             java.sql.Date delivery_date, Optional<String>contact_person){
        projectService.modifyProject(id,companyName,PO_number,amount,project_status,start_date,delivery_date,contact_person);
        return showAllProjects();

    }
}
