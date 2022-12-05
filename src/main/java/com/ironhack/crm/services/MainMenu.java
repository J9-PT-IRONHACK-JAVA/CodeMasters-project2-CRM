package com.ironhack.crm.services;

import com.ironhack.crm.services.ServiceManager;
import com.ironhack.crm.utils.Commands;
import com.ironhack.crm.utils.ScannerConfig;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {

    private final LeadService leadService;
    private final OpportunityService opportunityService;
    private final ContactService contactService;
    private final SalesRepService salesRepService;
    private final AccountService accountService;
    private final Scanner userInput;
    private final Commands commands;

    public MainMenu(LeadService leadService, OpportunityService opportunityService, ContactService contactService,
                    SalesRepService salesRepService, AccountService accountService, Scanner userInput, Commands commands) {
        this.leadService = leadService;
        this.opportunityService = opportunityService;
        this.contactService = contactService;
        this.salesRepService = salesRepService;
        this.accountService = accountService;
        this.userInput = userInput;
        this.commands = commands;
    }

    public void start() {

        String command = "start";

        commands.displayAvailableCommands();

        do {

            System.out.println("Type your command:");
            command = userInput.nextLine();

            if (command.equals("New Lead")) {
                leadService.createNewLead(userInput);
            } else if (command.equals("Show Leads")) {
                //Show all leads
            } else if (command.split(" ")[0].equals("lookup")) {
                opportunityService.printOpportunity(command);
            } else if (command.split(" ")[0].equals("convert")) {
                //Convert Lead to Opportunity
            } else if (command.split("-")[0].equals("close")) {
                Long id = Long.valueOf(command.split(" ")[1]);

                opportunityService.changeOpportunityStatus(id, command);

            } else {
                System.out.println("Wrong command!");
            }
        } while(!command.equals("exit"));
    }
}
