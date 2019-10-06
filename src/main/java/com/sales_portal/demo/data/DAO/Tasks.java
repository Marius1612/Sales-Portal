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
    private String message;
    private Date date_created;
    private Date ToDo_date;
    private Integer user_id;


    @ManyToMany
    @JoinTable(name = "company_to_contact")
    private Set<Contact> contact;


    @Builder
    public Tasks(String message, Date date_created,
                 Date ToDo_date, Integer user_id){

    }
}
