package com.sales_portal.demo.data.restControlers;

import com.sales_portal.demo.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private ICompanyService companyService;


//    @GetMapping("company/all")
//    public List<CompanyDTO> getAll() {
//        return companyService.getAllCompanies();
//    }

//    @GetMapping("company/insert")
//    public void insertCompany(String company_name, String company_website, String phone_number, String address, String invoicing_details) {
//        companyService.insertCompany(company_name, company_website, phone_number, address,invoicing_details);
//    }
}

