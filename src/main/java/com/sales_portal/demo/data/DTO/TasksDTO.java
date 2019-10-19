package com.sales_portal.demo.data.DTO;

import com.sales_portal.demo.data.DAO.Tasks;
import lombok.Getter;

import java.util.Date;

@Getter
public class TasksDTO {
    private Integer task_id;
    private String comment;
    private Date followUpDate;
    private Integer user_id;

    public TasksDTO(Tasks t) {
        this.task_id = task_id;
        this.comment = comment;
        this.followUpDate = followUpDate;
        this.user_id = user_id;
    }


}
