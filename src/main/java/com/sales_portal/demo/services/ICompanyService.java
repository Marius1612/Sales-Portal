package com.sales_portal.demo.services;


import com.sales_portal.demo.data.DTO.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {

    List<CompanyDTO> getAllCompanies();

    List<CompanyDTO> listCompanyByName(String company_name);

    void insertCompany(String company_name, String company_website,
                       String phone_number,
                       String company_address, String invoicing_details);

    void modifyCompany(Integer id, Optional<String> company_name,
                       Optional<String> company_website,
                       Optional<String> company_address,
                       Optional<String>phone_number,
                       Optional<String>invoicing_details);


    void deleteCompany(Integer id);
}




