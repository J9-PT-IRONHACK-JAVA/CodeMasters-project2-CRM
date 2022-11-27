package com.ironhack.crm.services;

import com.ironhack.crm.model.*;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ServiceManager {


// display all available commands
    public static void displayAvailableCommands() {
        System.out.println("============= ======== ===== === == = =\n" + "\n"
            + "\033[1;31m" + "IMPORTANT" + "\033[0m" + ": the commands are Case-Sensitive!\n"
            + "\n"
            + "You have the following commands available: \n"
            + "- To " + "\033[1;32m" + "lookup a lead " + "\033[0m" + ", type: " + "\033[1;32m" + "'Lookup ##' " +
                "\033[0m" + ", where '##' corresponds to the unique numeric identifier of the lead to show.\n"
            + "- To " + "\033[1;32m" + "show all leads " + "\033[0m" + ", type: " + "\033[1;32m" + "'Show Leads'" +
                "\033[0m" + ".\n"
            + "- To " + "\033[1;32m" + "create a new lead " + "\033[0m" + ", type: " + "\033[1;32m" +
                "'New Lead'" + "\033[0m" + ". You will be prompted to input the information necessary to create the lead instance.\n"
            + "- To " + "\033[1;32m" + "convert a lead into an opportunity" + "\033[0m" + ", type: " +
                "\033[1;32m" + "'convert ##'"  + "\033[0m" + ", where '##' corresponds to the unique numeric " +
                "identifier of the lead to convert.\n  You will be prompted to input the info necessary to create an " +
                "ooportunity instance.\n"
            + "- To " + "\033[1;32m" + "change the status of an opportunity" + "\033[0m" + ", type: " +
                    "\033[1;32m" + "'close-won ##' or 'close-lost ##'"  + "\033[0m" + ",\n  where '##' corresponds " +
                    "to the unique numeric identifier of the opportunity to modify.\n"
            + "\n"
            + "============= ======== ===== === == = =\n");
    }


    // lead creation

    // lookup lead

    // show all leads

    // delete lead (after contact added to an account)

// lead to opportunity conversion (aggregates lead->contact + opp creation)
    public static Opportunity leadToOpportunity(Lead leadToConvert, Scanner scanner) {

        Contact opportunityDecisionMaker = convertLeadToContact(leadToConvert);

        Opportunity opportunity = createOpportunity(leadToConvert, opportunityDecisionMaker, scanner);

        // add opportunity to hashmap
        Opportunity.mapOfOpportunities.put(opportunity.getOpportunityId(), opportunity);

        return opportunity;
    }

// lead to contact conversion
    public static Contact convertLeadToContact(Lead leadToConvert) {
        var contactFromLead = new Contact(leadToConvert);
        return contactFromLead;
    }

// opportunity creation
    public static Opportunity createOpportunity(Lead leadToConvert, Contact decisionMaker, Scanner scanner) {
        var opportunityFromLead = new Opportunity();
        String selectedProduct = null;
        Integer quantityDesired = null;

        opportunityFromLead.setDecisionMaker(decisionMaker);
        opportunityFromLead.setStatus(OpportunityStatus.OPEN);

        System.out.println("Please, input the " + "\033[1;32m" + "desired product" + "\033[0m" + " for this opportunity \n"
        + "You may one of the following: Hybrid Truck, Flatbed Truck, or Box Truck\n");

        while (selectedProduct == null) {
            try {
            if (scanner.nextLine().toLowerCase() != "hybrid truck" || selectedProduct.toLowerCase() !=  "flatbed truck" ||
                    selectedProduct.toLowerCase() != "box truck") {
                System.out.println("Invalid input:\nPlease introduce one of the following: Hybrid Truck, Flatbed Truck, or Box Truck\n");
            } else selectedProduct = scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input:\nPlease introduce one of the following: Hybrid Truck, Flatbed Truck, or Box Truck\n");
            }
        }

        if (selectedProduct.toLowerCase() == "hybrid truck") {
            opportunityFromLead.setProduct(Trucks.HYBRID);
        } else if (selectedProduct.toLowerCase() == "flatbed truck") {
            opportunityFromLead.setProduct(Trucks.FLATBED);
        } else if (selectedProduct.toLowerCase() == "box truck") {
            opportunityFromLead.setProduct(Trucks.BOX);
        }

        System.out.println("Please, input the " + "\033[1;32m" + "desired quantity" + "\033[0m" + " of products for"
                + "this opportunity. Only integer numbers are accepted as input. \n");

        while (quantityDesired == null) {
            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input:\nPlease introduce an integer number corresponding to the " +
                            "amount of trucks desired by the potential customer.\n");
                } else selectedProduct = scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input:\nPlease introduce an integer number corresponding to the " +
                        "amount of trucks desired by the potential customer.\n");
            }
        }
        opportunityFromLead.setQuantity(quantityDesired);


        return opportunityFromLead;
    }

    // change opportunity status
    public static void changeOpportunityStatus(Long opportunityId, String command) {

        if (command.split("-")[1].equals("won")) {
            Opportunity.mapOfOpportunities.get(opportunityId).setStatus(OpportunityStatus.CLOSED_WON);
        } else if (command.split("-")[1].equals("lost")) {
            Opportunity.mapOfOpportunities.get(opportunityId).setStatus(OpportunityStatus.CLOSED_LOST);
        }

    }

    // account creation

    // reporting


}
