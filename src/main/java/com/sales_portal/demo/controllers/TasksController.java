package com.sales_portal.demo.controllers;

import com.sales_portal.demo.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class TasksController {
    private TasksService tasksService;

    @RequestMapping({"mvc/tasks/showAll"})
    public ModelAndView showAllTasks(){
        ModelAndView mv = new ModelAndView("showAllTasks");
        mv.addObject("tasks",tasksService.getAllTasks());
        return mv;
    }


}
