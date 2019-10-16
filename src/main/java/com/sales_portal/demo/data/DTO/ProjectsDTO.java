package com.sales_portal.demo.data.DTO;

import com.sales_portal.demo.data.DAO.Projects;
import lombok.Getter;

import java.util.Date;

@Getter
public class ProjectsDTO {
    private Integer project_id;
    private String company_name;
    private String PO_number;
    private Double amount;
    private String project_status;
    private Date start_date;
    private Date delivery_date;
    private String contact_person;
    private Integer user_id;


    public ProjectsDTO(Projects p){
        this.project_id=p.getProject_id();
        this.company_name= p.getCompany_name();
        this.PO_number = p.getPO_number();
        this.amount = p.getAmount();
        this.project_status = p.getProject_status();
        this.start_date = p.getStart_date();
        this.delivery_date = p.getDelivery_date();
        this.contact_person = p.getContact_person();
    }
}
