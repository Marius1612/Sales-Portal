package com.sales_portal.demo.data.repositories;

import com.sales_portal.demo.data.DAO.PendingUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingUserRepository extends CrudRepository<PendingUser, Integer> {
}
