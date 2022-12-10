package com.ironhack.crm.model;
import com.ironhack.crm.utils.SalesRepStatus;
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
    private String password;
    private SalesRepStatus status;

    public SalesRep(String salesRepName, String salesRepEmail, String password) {
        this.salesRepName = salesRepName;
        this.salesRepEmail = salesRepEmail;
        this.password = password;
        this.status = SalesRepStatus.ONLINE;
    }

    @Override
    public String toString() {
        return "SalesRep: " +
                "   salesRepId= " + salesRepId + "\n" +
                "   salesRepName= " + salesRepName + "\n" +
                "   salesRepEmail= " + salesRepEmail + "\n" +
                "   salesRepStatus= " + status + "\n" +
                "======== ===== === == = =" + "\n";
    }
}
