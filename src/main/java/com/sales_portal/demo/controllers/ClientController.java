package com.sales_portal.demo.controllers;

import com.sales_portal.demo.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ClientController {
    private CompanyService companyService;


    @RequestMapping({"mvc/company/showAll","/"})
    public ModelAndView showAllCompanies(){
        ModelAndView mv = new ModelAndView("showCompanyList");
        mv.addObject("company", companyService.getAllCompanies());
        mv.addObject("search", "");

        return mv;
    }

    @PostMapping("mvc/company/showAll")
    public ModelAndView search(String search){
        ModelAndView mv = new ModelAndView("showCompanyList");
        mv.addObject("company", companyService.listCompanyByName(search));
        mv.addObject("search", search);
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
    public ModelAndView modifyCompanyDetails(@PathVariable Integer id, Optional<String> company_name,
                                             Optional<String> company_website, Optional<String> company_address,
                                             Optional<String>phone_number, Optional<String>invoicing_details){
        companyService.modifyCompany(id,company_name, company_website, phone_number,
                company_address, invoicing_details);
        return showAllCompanies();

    }

    @RequestMapping("mvc/company/{id}/delete")
    public ModelAndView deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return showAllCompanies();

    }


}
