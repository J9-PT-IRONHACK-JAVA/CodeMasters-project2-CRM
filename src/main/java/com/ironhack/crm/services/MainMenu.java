package com.ironhack.crm.services;

import com.ironhack.crm.utils.Commands;
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
                leadService.createNewLead();

            } else if (command.equals("Show Leads")) {
                leadService.showAllLeads();

            } else if (command.split(" ")[0].equals("Lookup")) {
                opportunityService.printOpportunity(command);

            } else if (command.split(" ")[0].equals("convert")) {
                Long id = Long.valueOf(command.split(" ")[1]);
                leadService.leadToOpportunity(id);

            } else if (command.split("-")[0].equals("close")) {
                Long id = Long.valueOf(command.split(" ")[1]);
                opportunityService.changeOpportunityStatus(id, command);

            } else if (command.equals("show commands")) {
                commands.displayAvailableCommands();

            } else if (command.equals("Show Opportunities")) {
                opportunityService.showAllOpps();

            } else if (command.split(" ")[0].equals("Search")) {
                var name = command.split(" ")[2];
                leadService.findLeadsByName(name);

            } else {
                System.out.println("Wrong command!");
            }
        } while(!command.equals("exit"));
        userInput.close();
    }
}
