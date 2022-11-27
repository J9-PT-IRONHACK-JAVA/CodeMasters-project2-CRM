package com.ironhack.crm.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Entity
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opportunityId;

    private Trucks product;
    private Integer quantity;
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
