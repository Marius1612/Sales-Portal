package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.Projects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Projects, Integer> {
}
