package com.sales_portal.demo.data.DAO;

import javax.persistence.*;

@Entity

public class Projects {

    @Id
    private Integer project_id;
    private String company_name;
    private String PO_number;
    private Double amount;
    private String project_status;
    private String start_date;
    private String delivery_date;
    private String contact_person;
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
