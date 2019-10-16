package com.sales_portal.demo.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "contact")
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contact_id;
    private String contact_name;
    private String company_name;
    private String email;
    private String phone_number;
    private String address;
    private Integer user_id;

    @OneToMany(mappedBy = "contact")
    private List<Projects> projects;

    @ManyToOne
    @JoinColumn
    private Company company;

    @Builder
    public Contact(String contact_name, String company_name,
                   String email, String phone_number, String address, Integer user_id) {

        this.contact_name = contact_name;
        this.company_name = company_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.user_id = user_id;

    }
}