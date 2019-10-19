package com.sales_portal.demo.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "projects")
@NoArgsConstructor
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;
    private String companyName;
    private String PO_number;
    private Double amount;
    private String project_status;
    private java.sql.Date start_date;
    private java.sql.Date delivery_date;
    private String contact_person;
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Builder
    public Projects(Integer project_id, String companyName, String PO_number, Double amount, String project_status,
                    java.sql.Date start_date, java.sql.Date delivery_date, String contact_person, Integer user_id, Contact contact) {
        this.project_id = project_id;
        this.companyName = companyName;
        this.PO_number = PO_number;
        this.amount = amount;
        this.project_status = project_status;
        this.start_date = start_date;
        this.delivery_date = delivery_date;
        this.contact_person = contact_person;
        this.user_id = user_id;
        this.contact = contact;
    }


}
