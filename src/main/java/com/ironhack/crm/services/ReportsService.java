package com.ironhack.crm.services;

import com.ironhack.crm.model.Account;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.repository.*;
import com.ironhack.crm.utils.Trucks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportsService {

    private final LeadRepository leadRepository;
    private final ContactRepository contactRepository;
    private final OpportunityRepository opportunityRepository;
    private final AccountRepository accountRepository;
    private final SalesRepRepository salesRepRepository;

    public void reportCaller(String command) {
        //*By SalesRep *//
        if (command.contains("by salesrep")) {
            if (command.contains("report lead")) {
                leadsBySalesRep(SalesRep.salesRepName);
            }
            else if (command.contains("report opportunity")) {
                opportunitiesBySalesRep(SalesRep.salesRepName);
            }
            else if (command.contains("closed won opportunities")) {
                closedWonOpportunities(SalesRep.salesRepName);
            }
            else if (command.contains("closed lost opportunities")) {
                closedLostOpportunities(SalesRep.salesRepName);
            }
            else if (command.contains("open opportunities")) {
                openOpportunities(SalesRep.salesRepName);
            }}

        //* by Product *//
        else if (command.contains("by product")) {
            String product = null;
            if (command.contains("flatbed truck")) {
                product = "flatbed truck";
            }
                else if (command.contains("box truck")) {
                    product = "box truck";
                }
                else if (command.contains("hybrid truck")) {
                    product = "hybrid truck";
                }
            if (command.contains(("Report opportunity"))) {
                opportunitiesByProduct(String.valueOf(product));
            }
            else if (command.contains("Report closed won opportunities")) {
                closedWonOpportunitiesByProduct(String.valueOf(product));
            }
            else if (command.contains("Report closed lost opportunities")) {
                closedLostOpportunitiesByProduct(String.valueOf(product));
            }
            else if (command.contains("Open opportunities")) {
                openOpportunitiesByProduct(String.valueOf(product));
            }

        //* by Country *//
        } else if (command.contains("by country")) {
            if (command.contains("Report opportunity")){
             opportunitiesByCountry(Account.country);
            }
            else if (command.contains("Report closed won opportunities")){
                closedWonOpportunitiesByCountry(Account.country);
            }
            else if (command.contains("Report closed lost opportunities")){

            }
            else if (command.contains("Report open opportunities")){

            }

        } else if (command.contains("by city")) {


        } else if (command.contains("by industry")) {

        } else if (command.contains("by employee count states")) {

        } else if (command.contains("by quantity states")) {

        } else if (command.contains("by opportunity states")) {

        } else {
            System.out.println("Incorrect command. Please try again. ");
        }


    }

    //* By salesRep *//
    public void leadsBySalesRep(String salesRepName) {
        var count = SalesRepRepository.countLeadBySalesRep(salesRepName);
        System.out.println("The SalesRep " + salesRepName + " has " + count + " leads.");
    }
    public void opportunitiesBySalesRep(String salesRepName) {
        var count = SalesRepRepository.countOpportunitiesBySalesRep(salesRepName);
        System.out.println("The SalesRep " + salesRepName + " has " + count + " opportunities.");
    }
    public void closedWonOpportunities(String salesRepName) {
        var count = SalesRepRepository.closedWonOpportunitiesBySalesRep(salesRepName);
        System.out.println("The SalesRep " + salesRepName + " has " + count + " closed and won opportunities");
    }
    public void closedLostOpportunities(String salesRepName) {
        var count = SalesRepRepository.closedLostOpportunitiesBySalesRep(salesRepName);
        System.out.println("The SalesRep " + salesRepName + " has " + count + " closed and won opportunities");
    }
    public void openOpportunities(String salesRepName) {
        var count = SalesRepRepository.openOpportunitiesbySalesRep(salesRepName);
        System.out.println("The SalesRep " + salesRepName + " has " + count + " closed and won opportunities");
    }


    //* by Product *//
    public void opportunitiesByProduct(String product) {
        Trucks enumProd = null;
        switch (product.toLowerCase()) {
            case "flatbed truck" -> enumProd = Trucks.FLATBED;
            case "box truck" -> enumProd = Trucks.BOX;
            case "hybrid truck" -> enumProd = Trucks.HYBRID;
        }
        var count = opportunityRepository.countOpportunitiesByProduct(enumProd);
        System.out.println("The product " + enumProd + " has " + count + " opportunities related to it.");
    }
    public void closedWonOpportunitiesByProduct(String product) {
        Trucks enumProd = null;
        switch (product.toLowerCase()) {
            case "flatbed truck" -> enumProd = Trucks.FLATBED;
            case "box truck" -> enumProd = Trucks.BOX;
            case "hybrid truck" -> enumProd = Trucks.HYBRID;
        }
        var count = opportunityRepository.countClosedWonOpportunitiesByProduct(enumProd);
        System.out.println("The product " + enumProd + " has " + count + " closed and won opportunities related to it.");
    }
    public void closedLostOpportunitiesByProduct(String product) {
        Trucks enumProd = null;
        switch (product.toLowerCase()) {
            case "flatbed truck" -> enumProd = Trucks.FLATBED;
            case "box truck" -> enumProd = Trucks.BOX;
            case "hybrid truck" -> enumProd = Trucks.HYBRID;
        }
        var count = opportunityRepository.countClosedLostOpportunitiesByProduct(enumProd);
        System.out.println("The product " + enumProd + " has " + count + " closed and won opportunities related to it.");
    }
    public void openOpportunitiesByProduct(String product) {
        Trucks enumProd = null;
        switch (product.toLowerCase()) {
            case "flatbed truck" -> enumProd = Trucks.FLATBED;
            case "box truck" -> enumProd = Trucks.BOX;
            case "hybrid truck" -> enumProd = Trucks.HYBRID;
        }
        var count = opportunityRepository.openOpportunitiesByProduct(enumProd);
        System.out.println("The product " + enumProd + " has " + count + " closed and won opportunities related to it.");
    }


//* by Country *//

    public void opportunitiesByCountry(String country) {
        var count = opportunityRepository.countOpportunitiesByCountry(country);
        System.out.println("The country " + country + " has " + count + " opportunities related to it.");
    }
    public void closedWonOpportunitiesByCountry(String country) {
        var count = opportunityRepository.closedWonOpportunitiesByCountry(country);
        System.out.println("The country " + country + " has " + count + " closed and won opportunities related to it.");
    }


}
