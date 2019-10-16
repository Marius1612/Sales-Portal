package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DTO.ProjectsDTO;

import java.util.Date;
import java.util.List;

public interface IProjectService {
    List<ProjectsDTO>getAllProjects();
    void insertProject(String company_name, String po_number, Double amount,
                       String project_status, Date start_date, Date delivery_date,
                       String contact_person);
}
