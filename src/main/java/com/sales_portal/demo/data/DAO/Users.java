package com.sales_portal.demo.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
@NoArgsConstructor
public class Users {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String emailAddress;
    private String password;
    private String name;

    @Builder
    private Users(Integer user_id, String emailAddress, String password, String name){
        this.user_id = user_id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.name = name;
    }

    @OneToOne(mappedBy = "user")
    private PendingUser pendingUser;


}
