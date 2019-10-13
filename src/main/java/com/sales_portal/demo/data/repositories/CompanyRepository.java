package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository <Company, Integer>{
        Optional<Company> findById(Integer company_id);


        Iterable<Company> findByCompanyName(String companyName);
}
