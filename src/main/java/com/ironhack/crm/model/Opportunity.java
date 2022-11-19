package com.ironhack.crm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Opportunity {

    private static int id = 0;
    private int opportunityId;
    private Trucks product;
    private int quantity;
    private Contact decisionMaker;
    private OpportunityStatus status;

    public Opportunity(Trucks product, int quantity, Contact decisionMaker, OpportunityStatus status) {
        setOpportunityId(id++);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }
}
