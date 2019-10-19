package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Tasks;
import com.sales_portal.demo.data.DTO.TasksDTO;

import java.util.List;

public interface ITaskService {
    List<TasksDTO>getAllTasks();
}
