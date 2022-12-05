package com.ironhack.crm.services;

import com.ironhack.crm.model.Contact;
import com.ironhack.crm.model.Lead;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.repository.ContactRepository;
import com.ironhack.crm.repository.LeadRepository;
import com.ironhack.crm.repository.OpportunityRepository;
import com.ironhack.crm.utils.InputValidations;
import com.ironhack.crm.utils.ScannerConfig;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final ContactRepository contactRepository;
    private final InputValidations inputValidations;
    private final OpportunityService opportunityService;
    private final Scanner userInput;
    private final OpportunityRepository opportunityRepository;

    public LeadService(LeadRepository leadRepository, ContactRepository contactRepository,
                       InputValidations inputValidations, OpportunityService opportunityService, Scanner userInput,
                       OpportunityRepository opportunityRepository) {
        this.leadRepository = leadRepository;
        this.contactRepository = contactRepository;
        this.inputValidations = inputValidations;
        this.opportunityService = opportunityService;
        this.userInput = userInput;
        this.opportunityRepository = opportunityRepository;
    }

    public Lead createNewLead(Scanner userInput) {
        String leadName = null;
        String phoneNumber = null;
        String email = null;
        String companyName = null;

        while (leadName == null) {
            System.out.println("Please introduce the name of your new lead");

            if (userInput.hasNextLine()) {
                if (!inputValidations.validateName(userInput.nextLine())) {
                    System.out.println("Wrong input. Please introduce a name in the format 'Firstname Lastname'.\n");
                } else leadName = userInput.nextLine();
            }

        }

        while (phoneNumber == null) {
            System.out.println("Please introduce the phone number of your new lead");

            if (userInput.hasNextLine()) {
                if (!inputValidations.validatePhone(userInput.nextLine())) {
                    System.out.println("Wrong input. Please introduce a valid phone number.");
                } else phoneNumber = userInput.nextLine();
            }

        }

        while (email == null) {
            System.out.println("Please introduce the email address of your new lead");

            if (userInput.hasNextLine()) {
                if (!inputValidations.validateEmail(userInput.nextLine())) {
                    System.out.println("Wrong input. Please introduce a valid email.");
                } else email = userInput.nextLine();
            }

        }

        while (companyName == null) {
            System.out.println("Please introduce the Company Name of your new lead");

            if (userInput.hasNextLine()) companyName = userInput.nextLine();

        }

        Lead newLead = new Lead(leadName, phoneNumber, email, companyName);

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
    public Opportunity leadToOpportunity(Long leadId, Scanner userInput) {

        Contact opportunityDecisionMaker = convertLeadToContact(leadId);

        Opportunity opportunity = opportunityService.createOpportunity(opportunityDecisionMaker, userInput);

        opportunityRepository.save(opportunity);

        return opportunity;
    }

    public void findLeadByName(String name) {
        var lead = leadRepository.findLeadByNameEquals(name);
        System.out.println(lead);
    }

    // delete lead (after contact added to an account)
}
