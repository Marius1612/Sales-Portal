package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Projects;
import com.sales_portal.demo.data.DTO.ProjectsDTO;
import com.sales_portal.demo.data.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("IContactProjects")
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


}
