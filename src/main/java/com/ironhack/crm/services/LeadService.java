package com.ironhack.crm.services;

import com.ironhack.crm.model.Contact;
import com.ironhack.crm.model.Lead;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.repository.AccountRepository;
import com.ironhack.crm.repository.ContactRepository;
import com.ironhack.crm.repository.LeadRepository;
import com.ironhack.crm.repository.OpportunityRepository;
import com.ironhack.crm.utils.InputValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;
    private final ContactRepository contactRepository;
    private final OpportunityService opportunityService;
    private final Scanner userInput;
    private final AccountService accountService;

    public Lead createNewLead() {
        String leadName = null;
        String phoneNumber = null;
        String email = null;
        String companyName = null;

        while (leadName == null || leadName.equals("")) {
            System.out.println("Please introduce the name of your new lead");

            var input= userInput.nextLine();

            if (!InputValidations.validateName(input)) {
                System.out.println("Wrong input. Please introduce a name in the format 'Firstname Lastname'.\n");

            } else leadName = input;
        }


        while (phoneNumber == null) {
            System.out.println("Please introduce the phone number of your new lead");

            var input = userInput.nextLine();

            if (!InputValidations.validatePhone(input)) {
                System.out.println("Wrong input. Please introduce a valid phone number.");
            } else phoneNumber = input;
        }


        while (email == null) {
            System.out.println("Please introduce the email address of your new lead");

            var input = userInput.nextLine();

            if (!InputValidations.validateEmail(input)) {
                System.out.println("Wrong input. Please introduce a valid email.");
            } else email = input;
        }


        while (companyName == null) {
            System.out.println("Please introduce the Company Name of your new lead");

            if (userInput.hasNextLine()) {
                companyName = userInput.nextLine();
            }
        }

        var newLead = new Lead(leadName, phoneNumber, email, companyName);

        leadRepository.save(newLead);

        System.out.println(newLead);

        return newLead;
    }

    // lead to contact conversion
    public Contact convertLeadToContact(Long leadId) {
        var leadToConvert = leadRepository.findLeadByLeadId(leadId);
        var contactFromLead = new Contact(leadToConvert);
        contactRepository.save(contactFromLead);
        return contactFromLead;
    }

    // lead to opportunity conversion (aggregates lead->contact + opp creation)
    public Opportunity leadToOpportunity(Long leadId) {

        var lead = leadRepository.findLeadByLeadId(leadId);
        System.out.println("Lead to convert: \n" + lead);

        var opportunityDecisionMaker = convertLeadToContact(leadId);

        var opportunity = opportunityService.createOpportunityFromContact(opportunityDecisionMaker);

        var account = accountService.createAccountFromLead(opportunityDecisionMaker, opportunity);

        System.out.println("\033[1;34mAccount created:\033[0m \n" + account);
        System.out.println("\033[1;34mOpportunity created:\033[0m \n" + opportunity);
        System.out.println("\033[1;34mOpportunity decision-maker:\033[0m \n" + opportunityDecisionMaker);

//        deleteLead(leadId);

        return opportunity;
    }

    public void findLeadsByName(String name) {
        var lead = leadRepository.findLeadByNameContaining(name);
        System.out.println(lead);
    }

    public void showAllLeads() {
        var leads = leadRepository.findAll();
        System.out.println(leads);
    }

    public void deleteLead(Long leadId) {
        leadRepository.deleteLeadByLeadId(leadId);
    }

}
