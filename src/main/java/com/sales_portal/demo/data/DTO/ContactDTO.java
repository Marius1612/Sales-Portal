package com.sales_portal.demo.data.DTO;

import com.sales_portal.demo.data.DAO.Contact;
import lombok.Getter;

@Getter
public class ContactDTO {

    private Integer contact_id;
    private String contact_name;
    private String company_name;
    private String email;
    private String phone_number;
    private String address;



    public ContactDTO(Contact co) {
        this.contact_id= co.getContact_id();
        this.contact_name = co.getContact_name();
        this.company_name = co.getCompany_name();
        this.email = co.getEmail();
        this.phone_number = co.getPhone_number();
        this.address = co.getAddress();
    }
}
