package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TasksRepository extends CrudRepository<Tasks ,Integer>  {


}
