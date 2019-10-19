package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Contact;
import com.sales_portal.demo.data.DTO.ContactDTO;
import com.sales_portal.demo.data.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("IContactService")
@AllArgsConstructor


public class ContactService implements  IContactService{
    private ContactRepository contactRepository;

    @Override
    public List<ContactDTO> getAllContacts() {
        List<ContactDTO> contacts = new ArrayList<ContactDTO>();
        Iterable<Contact> all = contactRepository.findAll();
        all.forEach(co -> contacts.add(new ContactDTO(co)));
        return contacts;
    }

    public void insertContact(String contact_name, String company_name,
                              String phone_number, String email, String address) {
        Contact co = Contact.builder().contact_name(contact_name).company_name(company_name)
                .phone_number(phone_number).email(email).address(address).build();

        contactRepository.save(co);
    }


    @Override
    public void deleteContact(Integer id) {

        contactRepository.deleteById(id);
    }



    @Override
    public void modifyContact(Integer id, Optional<String> contact_name,
                              Optional<String> company_name, Optional<String> email,
                              Optional<String>phone_number, Optional<String>address) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(co -> {

            contact_name.ifPresent( w -> co.setContact_name(w));
            company_name.ifPresent(n -> co.setCompany_name(n));
            email.ifPresent( e -> co.setEmail(e));
            address.ifPresent(a -> co.setAddress(a));
            phone_number.ifPresent(a -> co.setPhone_number(a));


            contactRepository.save(co);
        });
    }

//    public void updateContact(String contact_name, String company_name,
//                              String email,String phone_number, String address) {
//        Contact co = Contact.builder().contact_name(contact_name).company_name(company_name)
//                .email(email).phone_number(phone_number)
//                .address(address).build();
//
//        contactRepository.save(co);
//    }

    public Contact getContact(Integer id){
        return contactRepository.findById(id).get();
    }


}
