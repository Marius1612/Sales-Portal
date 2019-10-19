package com.sales_portal.demo.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer task_id;
    private String comment;
    private Date followUpDate;
    private Date ToDo_date;
    private Integer user_id;


    @ManyToMany
    @JoinTable(name = "company_to_contact")
    private Set<Contact> contact;



    @Builder
    public Tasks(Integer task_id, String comment, Date followUpDate,
                  Integer user_id){

        this.task_id = task_id;
        this.comment = comment;
        this.followUpDate = followUpDate;
        this.user_id = user_id;
    }
}
