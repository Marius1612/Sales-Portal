package com.sales_portal.demo.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "company")
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;
    private String company_name;
    private String company_website;
    private String company_address;
    private String phone_number;
    private String invoicing_details;
    private Integer user_id;

    @ManyToMany
    @JoinTable(name = "company_to_contact")
    private Set<Contact> contact;


    @Builder
    public Company(String company_name,
                   String company_website, String phone_number, String company_address, String invoicing_details){
        this.company_name = company_name;
        this.company_address =company_address;
        this.company_website = company_website;
        this.phone_number = phone_number;
        this.invoicing_details=invoicing_details;

    }
}
