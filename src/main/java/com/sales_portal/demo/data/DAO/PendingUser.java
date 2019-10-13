package com.sales_portal.demo.data.DAO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "pending_user")
@NoArgsConstructor
public class PendingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String activationCode;
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public PendingUser(Integer id, String activationCode, Users user) {
        this.id = id;
        this.activationCode = activationCode;
        this.user = user;
    }

}
