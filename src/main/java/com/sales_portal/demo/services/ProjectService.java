package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Projects;
import com.sales_portal.demo.data.DTO.ProjectsDTO;
import com.sales_portal.demo.data.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service("IProjectService")
@AllArgsConstructor



public class ProjectService implements IProjectService {
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectsDTO> getAllProjects() {
        List<ProjectsDTO> projects = new ArrayList<ProjectsDTO>();
        Iterable<Projects> all = projectRepository.findAll();
        all.forEach(p -> projects.add(new ProjectsDTO(p)));
        return projects;
    }

    @Override
    public void insertProject(String company_name, String po_number, Double amount,
                              String project_status, Date start_date, Date delivery_date,
                              String contact_person) {
        Projects p = Projects.builder().company_name(company_name)
                .PO_number(po_number).amount(amount).project_status(project_status)
                .start_date(start_date).delivery_date(delivery_date)
                .contact_person(contact_person).build();
        projectRepository.save(p);

    }



}
