package com.ironhack.crm.services;

import com.ironhack.crm.utils.Commands;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class MainMenu {
    private final LeadService leadService;
    private final OpportunityService opportunityService;
    private final ContactService contactService;
    private final SalesRepService salesRepService;
    private final AccountService accountService;
    private final ReportsService reportsService;
    private final Scanner userInput;
    private final Commands commands;


    public void commandsReceptor() {

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
                leadService.printLeadById(command);

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

            } else if (command.equals("Show Accounts")) {
                accountService.showAllAccounts();

            } else if (command.split(" ")[0].equals("Lookup-opp")) {
                opportunityService.printOpportunity(command);

            } else if (command.equals("Show Contacts")) {
                contactService.findAllContacts();

            } else if (command.equals("show reports")) {
                commands.displayAvailableReports();

            }  else if (!command.equals("exit")){
                System.out.println("Wrong command!");
            }
//            }  else if (command.split(" ")[0].equals("Report") || command.split(" ")[0].equals("Mean") ||
  //                  command.split(" ")[0].equals("Median") || command.split(" ")[0].equals("Max") ||
    //                command.split(" ")[0].equals("Min")) {
//                reportsService.reportCaller(command);
//
  //          } else if (command.equals("logout")) {
    //            salesRepService.salesRepLogOut();
//
      //      } else {

        } while(!command.equals("exit"));
        userInput.close();
    }
}
