package com.sales_portal.demo.services;


import com.sales_portal.demo.data.DAO.Company;
import com.sales_portal.demo.data.DTO.CompanyDTO;
import com.sales_portal.demo.data.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ICompanyService")
@AllArgsConstructor

public class CompanyService implements ICompanyService{
            private CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> listCompanyByName(String company_name) {
        List<CompanyDTO> companies = new ArrayList<>();
        Iterable<Company> all = companyRepository
                .findByCompanyNameContaining(company_name);

        all.forEach(c -> companies.add(new CompanyDTO(c)));
        return companies;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> companies = new ArrayList<CompanyDTO>();
        Iterable<Company> all = companyRepository.findAll();

        all.forEach(c -> companies.add(new CompanyDTO(c)));
        return companies;
    }

    @Override
    public void insertCompany(String company_name, String company_website,
                              String phone_number,
                              String company_address, String invoicing_details) {
        Company c = Company.builder().companyName(company_name)
                .company_website(company_website).phone_number(phone_number)
                .company_address(company_address).invoicing_details(invoicing_details)
                .build();

        companyRepository.save(c);
    }

    public void updateCompany(String companyName, String company_website,
                              String phone_number,
                              String company_address, String invoicing_details) {
        Company c = Company.builder().companyName(companyName)
                .company_website(company_website).phone_number(phone_number)
                .company_address(company_address).invoicing_details(invoicing_details)
                .build();

        companyRepository.save(c);

    }


    @Override
    public void modifyCompany(Integer id, Optional<String> companyName,
                              Optional<String> company_website, Optional<String> company_address,
                              Optional<String>phone_number, Optional<String>invoicing_details) {
        Optional<Company> company = companyRepository.findById(id);
        company.ifPresent(c -> {
            companyName.ifPresent(n -> c.setCompanyName(n));
            company_website.ifPresent( w -> c.setCompany_website(w));
            company_address.ifPresent(a -> c.setCompany_address(a));
            phone_number.ifPresent(a -> c.setPhone_number(a));
            invoicing_details.ifPresent( i -> c.setInvoicing_details(i));

           // Company modifyCompany = companyRepository.save(company);


            companyRepository.save(c);
        });
    }



    @Override
    public void deleteCompany(Integer id) {

            companyRepository.deleteById(id);
    }


    public Company getCompany(Integer id){
        return companyRepository.findById(id).get();
    }


}
