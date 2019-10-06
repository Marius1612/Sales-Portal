package com.sales_portal.demo.data.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "invoicing_details")
@NoArgsConstructor
public class InvoicingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer account_no;
    @OneToOne
    @JoinColumn(name = "id")
    private Company company;
}
