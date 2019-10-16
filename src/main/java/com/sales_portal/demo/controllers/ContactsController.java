package com.sales_portal.demo.controllers;

import com.sales_portal.demo.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ContactsController {
    private ContactService contactService;

    @RequestMapping({"mvc/contact/showAll"})
    public ModelAndView showAllContacts(){
        ModelAndView mv = new ModelAndView("showContactList");
        mv.addObject("contact",contactService.getAllContacts());
        return mv;
    }

    @GetMapping("mvc/contact/insert")
    public String insertContact(){
        return "insertContact";
    }

    @PostMapping("mvc/contact/insert")
    public ModelAndView insertContact(String contact_name, String company_name, String phone_number,
                                      String email, String address){
        contactService.insertContact(contact_name,company_name,phone_number,email,address);
        return showAllContacts();

    }


    @RequestMapping("mvc/contact/{id}/delete")
    public ModelAndView deleteContact(@PathVariable Integer id){
        contactService.deleteContact(id);
        return showAllContacts();

    }

    @GetMapping("mvc/contact/{id}/modify")

    public ModelAndView modifyContact(@PathVariable Integer id, Optional<String> contact_name, Optional<String>  company_name,
                                      Optional<String>  phone_number,
                                      Optional<String>  email, Optional<String>  address){
        ModelAndView mv= new ModelAndView("modifyContact");
        mv.addObject("contact",contactService.getContact(id));
        contactService.modifyContact(id,contact_name,company_name,phone_number,email,address);

        return mv;

    }

    @PostMapping("mvc/contact/{id}/modify")
    public ModelAndView modifyContactDetails(@PathVariable Integer id,Optional<String> contact_name, Optional<String>  company_name,
                                             Optional<String>  phone_number,
                                             Optional<String>  email, Optional<String>  address){
        contactService.modifyContact(id,contact_name,company_name,
                phone_number,email,address);
        return showAllContacts();

    }
}
