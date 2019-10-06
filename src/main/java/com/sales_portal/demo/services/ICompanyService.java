package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DTO.CompanyDTO;

import java.util.List;

public interface ICompanyService {
   // List<CompanyDTO> getAllCompanies();

//  void modifyCompany(Integer id, Optional<String> name, Optional<String> email);
    void insertCompany(String company_name, String company_website, String phone_number, String company_address, String invoicing_details);
//    void deleteCompany(Integer id);
//    void changeInvoicingDetails(Integer userId,Optional<String> city, Optional<String> country,Optional<String> street );


    // prin getServiceTitle se face conectarea la un serviciu extern
//    String getServiceTitle(Integer id) throws NotFoundException;

       List<CompanyDTO> getAllCompanies();
}
