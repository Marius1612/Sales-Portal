package com.sales_portal.demo.services;


import com.sales_portal.demo.data.DAO.Company;
import com.sales_portal.demo.data.DTO.CompanyDTO;
import com.sales_portal.demo.data.repositories.CompanyRepository;
import com.sales_portal.demo.data.repositories.ContactRepository;
import com.sales_portal.demo.data.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ICompanyService")
@AllArgsConstructor

public class CompanyService implements ICompanyService{
            private CompanyRepository companyRepository;
            private ContactRepository contactRepository;
            private ProjectRepository projectRepository;


    @Override
    public void insertCompany(String company_name, String company_website, String phone_number, String company_address, String invoicing_details) {
        Company c = Company.builder().company_name(company_name)
                .company_website(company_website).phone_number(phone_number)
                .company_address(company_address).invoicing_details(invoicing_details).build();

        companyRepository.save(c);
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> companies = new ArrayList<CompanyDTO>();
        Iterable<Company> all = companyRepository.findAll();

        all.forEach(c -> companies.add(new CompanyDTO(c)));
        return companies;
    }


//    @Override
//    public void sendMail(Integer userId, String subject, String content) {
//
//    }
//
//    @Override
//    public void modifyCompany(Integer id, Optional<String> name, Optional<String> email) {
//
//    }
//

//
//    @Override
//    public void deleteCompany(Integer id) {
//
//    }
//
//    @Override
//    public void changeInvoicingDetails(Integer userId, Optional<String> city, Optional<String> country, Optional<String> street) {
//
//    }
//
//    @Override
//    public String getUserName(Integer userId) {
//        return null;
//    }
//
//    @Override
//    public String getServiceTitle(Integer id) throws NotFoundException {
//        return null;
//    }
}
