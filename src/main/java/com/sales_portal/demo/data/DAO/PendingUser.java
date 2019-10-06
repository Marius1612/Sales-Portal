package com.sales_portal.demo.data.DAO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "pending_user")
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
    public PendingUser(Integer id, String activationCode, Date expireDate, Users user) {
        this.id = id;
        this.activationCode = activationCode;
        this.expireDate = expireDate;
        this.user = user;
    }
}
