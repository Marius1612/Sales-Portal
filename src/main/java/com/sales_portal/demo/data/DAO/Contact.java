package com.sales_portal.demo.data.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Contact {
    @Id
    private Integer contact_id;
    private String contact_name;
    private String company_name;
    private String email;
    private String phone_number;
    private String address;
    private Integer user_id;

    @ManyToMany(mappedBy = "contact")
    private Set<Company> companies;

    @OneToMany(mappedBy = "contact")
    private List<Projects> projects;
}