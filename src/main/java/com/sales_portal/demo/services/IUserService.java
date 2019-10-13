package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.Users;
import com.sales_portal.demo.data.DTO.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    String getEmailAddress(String emailAddress);
    void insertUser(String emailAddress, String password, String name);
    void sendMail(Integer userId, String subject, String content);
    void insertIntoPendingUser(String activationCode, Users user);

    //String linkCreator(String link, Integer user_Id);
}
