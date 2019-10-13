package com.sales_portal.demo.data.DTO;

import com.sales_portal.demo.data.DAO.Company;
import lombok.Getter;

@Getter
public class CompanyDTO {


    private Integer company_id;
    private String companyName;
    private String company_website;
    private String company_address;
    private String phone_number;
    private String invoicing_details;

    public CompanyDTO(Company c) {

        this.company_id = c.getCompany_id();
        this.companyName = c.getCompanyName();
        this.company_website = c.getCompany_website();
        this.company_address = c.getCompany_address();
        this.phone_number = c.getPhone_number();
        this.invoicing_details = c.getInvoicing_details();
    }
}
