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
    public static Long salesRepId;
    public static String salesRepName;
    public static String salesRepEmail;

    public SalesRep(String salesRepName, String salesRepEmail) {
        this.salesRepName = salesRepName;
        this.salesRepEmail = salesRepEmail;
    }

    @Override
    public String toString() {
        return "SalesRep: " +
                "   salesRepId= " + salesRepId + "\n" +
                "   salesRepName= " + salesRepName + "\n" +
                "   salesRepEmail= " + salesRepEmail + "\n" +
                "======== ===== === == = =" + "\n";
    }
}
