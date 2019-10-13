package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.PendingUser;
import com.sales_portal.demo.data.DAO.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PendingUserRepository extends CrudRepository<PendingUser, Integer> {
    Optional<PendingUser> findByActivationCode(String activationCode);

//    void deleteById(Integer id);
}
