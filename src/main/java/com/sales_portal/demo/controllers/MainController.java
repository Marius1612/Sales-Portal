package com.sales_portal.demo.controllers;

import com.sales_portal.demo.DemoApplication;
import com.sales_portal.demo.data.repositories.UserRepository;
import com.sales_portal.demo.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.nio.file.Path;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private CompanyService companyService;
    private UserService userService;
    private LoginService loginService;
    private ContactService contactService;
    private ProjectService projectService;



//Company


    @RequestMapping({"mvc/company/showAll","/"})
    public ModelAndView showAllCompanies(){
        ModelAndView mv = new ModelAndView("showCompanyList");
        mv.addObject("company", companyService.getAllCompanies());

        return mv;
    }

    @PostMapping("mvc/company/showAll")
    public ModelAndView search(String search){
        ModelAndView mv = new ModelAndView("showCompanyList");
        mv.addObject("company", companyService.listCompanyByName(search));
        return mv;
    }

    @GetMapping("mvc/company/insert")
    public String insertCompany(){
        return "insertCompany";
    }

    @PostMapping("mvc/company/insert")
    public ModelAndView insertCompany(String company_name, String company_website, String phone_number,
                                      String company_address, String invoicing_details){
        companyService.insertCompany(company_name, company_website, phone_number, company_address, invoicing_details);
        return showAllCompanies();

    }

    @GetMapping("mvc/company/{id}/modify")

    public ModelAndView modifyCompany(@PathVariable Integer id, Optional<String> company_name,
                                      Optional<String> company_website, Optional<String> company_address,
                                      Optional<String>phone_number, Optional<String>invoicing_details){
        ModelAndView mv= new ModelAndView("modifyCompany");
        mv.addObject("company",companyService.getCompany(id));
        companyService.modifyCompany(id,company_name, company_website, phone_number, company_address, invoicing_details);

        return mv;

    }

    @PostMapping("mvc/company/{id}/modify")
    public ModelAndView updateCompany(String company_name, String company_website, String phone_number,
                                      String company_address, String invoicing_details){
        companyService.updateCompany(company_name, company_website, phone_number, company_address, invoicing_details);
        return showAllCompanies();

    }

    @RequestMapping("mvc/company/{id}/delete")
    public ModelAndView deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return showAllCompanies();

    }

    @RequestMapping(value = "company/{search}", method = RequestMethod.GET)
    public String showCompanyByName(@PathVariable String company_name, Model model) {

        return "search";
    }
    //Company



    //Contact
    @RequestMapping({"mvc/contact/showAll"})
    public ModelAndView showAllContacts(){
        ModelAndView mv = new ModelAndView("showContactList");
        mv.addObject("contact",contactService.getAllContacts());
        return mv;
    }

    @GetMapping("mvc/contact/insert")
    public String insertContact(){
        return "insertContact";
    }

    @PostMapping("mvc/contact/insert")
    public ModelAndView insertContact(String contact_name, String company_name, String phone_number,
                                      String email, String address){
        contactService.insertContact(contact_name,company_name,phone_number,email,address);
        return showAllContacts();

    }


    @RequestMapping("mvc/contact/{id}/delete")
    public ModelAndView deleteContact(@PathVariable Integer id){
        contactService.deleteContact(id);
        return showAllContacts();

    }
    //Contact


    //Projects
    @RequestMapping({"mvc/projects/showAll"})
    public ModelAndView showAllProjects(){
        ModelAndView mv = new ModelAndView("showProjectList");
        mv.addObject("project",projectService.getAllProjects());
        return mv;
    }
    //Projects


    //Users
    @GetMapping("userValidation")
    public String validateUser( String activationCode){
        loginService.validateUser(activationCode);
        return "login";
               }

    @GetMapping("mvc/user/register")
    public String insertUser(){
        return "register";
    }

    @PostMapping("mvc/user/register")
    public ModelAndView insertUser(String emailAddress, String password, String name){
        userService.insertUser(emailAddress, password,name);
        return home();
            }

    @GetMapping("user/{userId}/sendMail")
    public void sendMail(@PathVariable Integer userId, String subject, String content){
        userService.sendMail(userId, subject, content);

    }

    //Users

    @RequestMapping("mvc/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("index");
        return mv;
    }

    @RequestMapping("mvc/help")
    public ModelAndView help(){
        ModelAndView mv = new ModelAndView("help");
        mv.addObject("help");
        return mv;
    }






//    @RequestMapping("/mvc/greet/{userId}")
//    public String greet(Model model, @PathVariable String emailAddress){
//        model.addAttribute("userName",userService.getEmailAddress(emailAddress));
//        return "welcome";
//    }
//    @RequestMapping("mvc/user/showAll")
//    public ModelAndView greet(){
//        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("users", userService.getAllUsers());
//        return mv;
//    }
}