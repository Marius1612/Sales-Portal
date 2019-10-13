package com.sales_portal.demo.services;



import com.sales_portal.demo.data.DTO.ContactDTO;

import java.util.List;

public interface IContactService {
    List<ContactDTO> getAllContacts();
    void insertContact(String contact_name,String company_name,String phone_number, String email, String address);
    void deleteContact(Integer id);
}
