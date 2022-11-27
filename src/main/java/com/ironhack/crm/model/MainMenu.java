package com.ironhack.crm.model;

import com.ironhack.crm.services.ServiceManager;

import java.util.Scanner;

public class MainMenu {

    public static void start() {

        var scanner = new Scanner(System.in);
        String command = "start";


        do {
            ServiceManager.displayAvailableCommands();

            System.out.println("Type your command:");
            command = scanner.nextLine();
            if (command.equals("New Lead")) {
                //Lead creation
            } else if (command.equals("Show Leads")) {
                //Show all leads
            } else if (command.split(" ")[0].equals("Lookup")) {
                //Look up
            } else if (command.split(" ")[0].equals("convert")) {
                //Convert Lead to Opportunity
            } else if (command.split("-")[0].equals("close")) {
                Long id = Long.valueOf(command.split(" ")[1]);

                ServiceManager.changeOpportunityStatus(id, command);

            } else {
                System.out.println("Wrong command!");
            }
        }while(!command.equals("exit"));
    }
}
