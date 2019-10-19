package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Projects;
import com.sales_portal.demo.data.DTO.ProjectsDTO;
import com.sales_portal.demo.data.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<ProjectsDTO> listCompanyByName(String companyName) {
        List<ProjectsDTO> projects = new ArrayList<>();
        Iterable<Projects> all = projectRepository
                .findByCompanyNameContaining(companyName);

        all.forEach(p -> projects.add(new ProjectsDTO(p)));
        return projects;
    }


    @Override
    public void insertProject(String companyName, String po_number, Double amount,
                              String project_status, java.sql.Date start_date, java.sql.Date delivery_date,
                              String contact_person) {
        Projects p = Projects.builder().companyName(companyName)
                .PO_number(po_number).amount(amount).project_status(project_status)
                .start_date(start_date).delivery_date(delivery_date)
                .contact_person(contact_person).build();
        projectRepository.save(p);

    }

    @Override
    public void modifyProject(Integer id, Optional<String> companyName,
                              Optional<String> PO_number, Optional<Double> amount,
                              Optional<String> project_status, java.sql.Date start_date,
                              java.sql.Date delivery_date, Optional<String> contact_person) {
        Optional<Projects> projects = projectRepository.findById(id);
        projects.ifPresent(p -> {
            companyName.ifPresent(n -> p.setCompanyName(n));
            PO_number.ifPresent( po -> p.setPO_number(po));
            amount.ifPresent(a -> p.setAmount(a));
            //start_date.ifPresent(sd -> p.setStart_date(sd));
            //delivery_date.ifPresent( dd -> p.setDelivery_date(dd));
            contact_person.ifPresent(cp -> p.setContact_person(cp));

            // Company modifyCompany = companyRepository.save(company);


            projectRepository.save(p);
        });
    }



    @Override
    public void deleteProject(Integer id)
    {

        projectRepository.deleteById(id);
    }


    public Object getProject(Integer id)
    {
        return projectRepository.findById(id).get();
    }

}
