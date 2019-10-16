package com.sales_portal.demo.services;



import com.sales_portal.demo.data.DTO.ContactDTO;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    List<ContactDTO> getAllContacts();
    void insertContact(String contact_name,String company_name,String phone_number, String email, String address);
    void deleteContact(Integer id);
    void modifyContact(Integer id, Optional<String> contact_name,
                       Optional<String> company_name, Optional<String> email,
                       Optional<String>phone_number, Optional<String>address);
}
