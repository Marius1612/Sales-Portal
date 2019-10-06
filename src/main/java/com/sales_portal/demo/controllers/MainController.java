package com.sales_portal.demo.controllers;

import com.sales_portal.demo.DemoApplication;
import com.sales_portal.demo.data.repositories.UserRepository;
import com.sales_portal.demo.services.CompanyService;
import com.sales_portal.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@AllArgsConstructor
public class MainController {

    private CompanyService companyService;
    private UserService userService;
    private UserRepository userRepository;


    @GetMapping("mvc/company/insert")
    public String insertCompany(){
        return "insertCompany";
    }

    @PostMapping("mvc/company/insert")
    public ModelAndView insertCompany(String company_name, String company_website, String phone_number, String company_address, String invoicing_details){
        companyService.insertCompany(company_name, company_website, phone_number, company_address, invoicing_details);
        return showAllCompanies();

    }
    @RequestMapping({"mvc/company/showAll","/"})
    public ModelAndView showAllCompanies(){
        ModelAndView mv = new ModelAndView("showCompanyList");
        mv.addObject("company", companyService.getAllCompanies());
        return mv;
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

    @GetMapping("user/{userId}/sendMail")
    public void sendMail(@PathVariable Integer userId, String subject, String content){
        userService.sendMail(userId, subject, content);

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