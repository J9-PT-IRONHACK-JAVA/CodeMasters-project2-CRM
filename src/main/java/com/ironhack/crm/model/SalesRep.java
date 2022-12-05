package com.ironhack.crm.model;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sales_reps")
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesRepId;
    private String salesRepName;
    private String salesRepEmail;

    public SalesRep(String salesRepName, String salesRepEmail) {
        this.salesRepName = salesRepName;
        this.salesRepEmail = salesRepEmail;
    }
}
