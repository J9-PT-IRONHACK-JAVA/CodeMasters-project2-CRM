package com.ironhack.crm.model;

import com.ironhack.crm.utils.OpportunityStatus;
import com.ironhack.crm.utils.Trucks;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Entity
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opportunityId;

    private Trucks product;
    private Integer quantity;
    @OneToOne
    private Contact decisionMaker;
    private OpportunityStatus status;
    @ManyToOne
    private SalesRep salesRep;

    public Opportunity(Trucks product, Integer quantity, Contact decisionMaker) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(OpportunityStatus.OPEN);
    }

    public Opportunity(Contact decisionMaker, OpportunityStatus status) {
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity:\n"
                + " opportunityId = " + opportunityId + "\n"
                + " product = " + product + "\n"
                + " quantity = " + quantity + "\n"
                + " decisionMaker = " + decisionMaker + "\n"
                + " status = " + status + "\n" +
                "======== ===== === == = =" + "\n";
    }
}
