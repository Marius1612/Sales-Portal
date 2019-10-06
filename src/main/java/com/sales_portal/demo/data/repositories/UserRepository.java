package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.Contact;
import com.sales_portal.demo.data.DAO.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByEmailAddress(String emailAddress);

}
