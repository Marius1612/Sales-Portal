package com.sales_portal.demo.data.DTO;

import com.sales_portal.demo.data.DAO.Users;
import lombok.Getter;

@Getter
public class UserDTO {
    private int user_id;
    private String emailAddress;
    private String password;
    private String name;

    public UserDTO (Users u) {
        this.user_id = u.getUser_id();
        this.emailAddress = u.getEmailAddress();
        this.password = u.getPassword();
    }
}
