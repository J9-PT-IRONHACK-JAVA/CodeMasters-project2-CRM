package com.ironhack.crm.services;

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

        if (command.contains("by product")) {
            if (command.contains("Report Opportunity")) {
                String product = null;

                if (command.contains("flatbed truck")) {
                    product = "flatbed truck";
                } else if (command.contains("box truck")) {
                    product = "box truck";
                } else if (command.contains("hybrid truck")) {
                    product = "hybrid truck";
                }

                opportunitiesByProduct(String.valueOf(product));
            }

        } else if (command.contains("by product")) {

        }


    }

// by Product
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


// by Country

//    public void opportunitiesByCountry(String country) {
//
//        var count = opportunityRepository.countOpportunitiesByCountry(country);
//
//
//        System.out.println("The country " + country + " has " + count + " opportunities related to it.");
//    }

// by SalesRep

}
