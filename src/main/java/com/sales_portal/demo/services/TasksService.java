package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Tasks;
import com.sales_portal.demo.data.DTO.TasksDTO;
import com.sales_portal.demo.data.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ITaskService")
@AllArgsConstructor

public class TasksService implements ITaskService {
    private TasksRepository tasksRepository;

    public List<TasksDTO> getAllTasks() {
        List<TasksDTO> tasks = new ArrayList<TasksDTO>();
        Iterable<Tasks> all = tasksRepository.findAll();
        all.forEach(t -> tasks.add(new TasksDTO(t)));
        return tasks;
    }
}
