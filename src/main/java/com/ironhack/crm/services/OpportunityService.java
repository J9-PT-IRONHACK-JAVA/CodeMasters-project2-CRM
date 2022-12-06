package com.ironhack.crm.services;

import com.ironhack.crm.model.Contact;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.repository.OpportunityRepository;
import com.ironhack.crm.utils.OpportunityStatus;
import com.ironhack.crm.utils.Trucks;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    // opportunity creation
    public Opportunity createOpportunity(Contact decisionMaker, Scanner userInput) {
        var opportunityFromLead = new Opportunity(decisionMaker, OpportunityStatus.OPEN);
        String selectedProduct = null;
        Integer quantityDesired = null;

        System.out.println("""
                Please, input the \033[1;32mdesired product\033[0m for this opportunity\s
                You may one of the following: Hybrid Truck, Flatbed Truck, or Box Truck
                """);

        while (selectedProduct == null) {
            try {
                if (userInput.nextLine().toLowerCase() != "hybrid truck"
                        || userInput.nextLine().toLowerCase() !=  "flatbed truck"
                        || userInput.nextLine().toLowerCase() != "box truck") {
                    System.out.println("Invalid input:\nPlease introduce one of the following: Hybrid Truck, Flatbed Truck, or Box Truck\n");
                } else selectedProduct = userInput.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input:\nPlease introduce one of the following: Hybrid Truck, Flatbed Truck, or Box Truck\n");
            }
        }

        switch (selectedProduct.toLowerCase()) {
            case "hybrid truck" -> opportunityFromLead.setProduct(Trucks.HYBRID);
            case "flatbed truck" -> opportunityFromLead.setProduct(Trucks.FLATBED);
            case "box truck" -> opportunityFromLead.setProduct(Trucks.BOX);
        }

        System.out.println("Please, input the " + "\033[1;32m" + "desired quantity" + "\033[0m" + " of products for"
                + "this opportunity. Only integer numbers are accepted as input. \n");

        while (quantityDesired == null) {
            try {
                if (!userInput.hasNextInt()) {
                    System.out.println("""
                            Invalid input:
                            Please introduce an integer number corresponding to the amount of trucks desired by the potential customer.
                            """);
                } else selectedProduct = userInput.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("""
                        Invalid input:
                        Please introduce an integer number corresponding to the amount of trucks desired by the potential customer.
                        """);
            }
        }
        opportunityFromLead.setQuantity(quantityDesired);

        opportunityRepository.save(opportunityFromLead);

        return opportunityFromLead;
    }

    public void changeOpportunityStatus(Long opportunityId, String command) {

        if (command.split("-")[1].equals("won")) {
            var opportunityToUpdate = opportunityRepository.findOpportunityByOpportunityId(opportunityId);
            if (opportunityToUpdate.isPresent()) {
                opportunityToUpdate.get().setStatus(OpportunityStatus.CLOSED_WON);
                opportunityRepository.save(opportunityToUpdate.get());
            }
        } else if (command.split("-")[1].equals("lost")) {
            var opportunityToUpdate =  opportunityRepository.findOpportunityByOpportunityId(opportunityId);
            if (opportunityToUpdate.isPresent()) {
                opportunityToUpdate.get().setStatus(OpportunityStatus.CLOSED_LOST);
                opportunityRepository.save(opportunityToUpdate.get());
            }
        }
    }

    public void printOpportunity(String command) {
        var oppId = Long.parseLong(command.split(" ")[1]);
        var opportunity = opportunityRepository.findOpportunityByOpportunityId(oppId);
        if (opportunity.isPresent()) {
            System.out.println(opportunity);
        } else {
            System.out.println("Any opportunity has this ID!");
        }
    }


}
