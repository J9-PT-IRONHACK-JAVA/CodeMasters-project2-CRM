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

    // hashmap de ooportunities por id para que sea fácil buscar y modificarlas (change status)
    public static HashMap<Long, Opportunity> mapOfOpportunities = new HashMap<>();

    public Opportunity(Trucks product, int quantity, Contact decisionMaker) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(OpportunityStatus.OPEN);

        // PENDING: add opport to hasmap
    }

    public static Opportunity findOpportunityById(Long opportunityId){


        return null;
    }

}
