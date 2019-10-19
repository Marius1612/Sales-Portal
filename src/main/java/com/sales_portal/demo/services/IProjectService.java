package com.sales_portal.demo.services;


import com.sales_portal.demo.data.DTO.ProjectsDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<ProjectsDTO>getAllProjects();


    List<ProjectsDTO> listCompanyByName(String companyName);

    void insertProject(String companyName, String po_number, Double amount,
                       String project_status, java.sql.Date start_date, java.sql.Date delivery_date,
                       String contact_person);

    void modifyProject(Integer id, Optional<String> companyName,
                       Optional<String> PO_number, Optional<Double> amount,
                       Optional<String> project_status, java.sql.Date start_date,
                       java.sql.Date delivery_date, Optional<String> contact_person);



    void deleteProject(Integer id);
}
