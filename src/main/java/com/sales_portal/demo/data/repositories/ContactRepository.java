package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
