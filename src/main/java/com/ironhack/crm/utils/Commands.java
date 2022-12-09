package com.ironhack.crm.utils;

import org.springframework.stereotype.Component;

@Component
public class Commands {

    // display all available commands
//    public void displayAvailableCommands() {
//        System.out.println("============= ======== ===== === == = =\n" + "\n"
//                + "\033[1;31m" + "IMPORTANT" + "\033[0m" + ": the commands are Case-Sensitive!\n"
//                + "\n"
//                + "You have the following commands available: \n"
//                + "- To " + "\033[1;32m" + "lookup a lead " + "\033[0m" + ", type: " + "\033[1;32m" + "'Lookup ##' " +
//                "\033[0m" + ", where '##' corresponds to the unique numeric identifier of the lead to show.\n"
//                + "- To " + "\033[1;32m" + "show all leads " + "\033[0m" + ", type: " + "\033[1;32m" + "'Show Leads'" +
//                "\033[0m" + ".\n"
//                + "- To " + "\033[1;32m" + "create a new lead " + "\033[0m" + ", type: " + "\033[1;32m" +
//                "'New Lead'" + "\033[0m" + ". You will be prompted to input the information necessary to create the lead instance.\n"
//                + "- To " + "\033[1;32m" + "convert a lead into an opportunity" + "\033[0m" + ", type: " +
//                "\033[1;32m" + "'convert ##'"  + "\033[0m" + ", where '##' corresponds to the unique numeric " +
//                "identifier of the lead to convert.\n  You will be prompted to input the info necessary to create an " +
//                "ooportunity instance.\n"
//                + "- To " + "\033[1;32m" + "change the status of an opportunity" + "\033[0m" + ", type: " +
//                "\033[1;32m" + "'close-won ##' or 'close-lost ##'"  + "\033[0m" + ",\n  where '##' corresponds " +
//                "to the unique numeric identifier of the opportunity to modify.\n"
//                + "\n"
//                + "============= ======== ===== === == = =\n");
//    }

    public void displayAvailableCommands() {
        System.out.println("""
                ============= ======== ===== === == = ="

                \033[1;31mIMPORTANT\033[0m 
                \033[1;31mThe commands are Case-Sensitive!\033[0m

                You have the following \033[1;32commands available:\033[0m
                > Leads
                - To \033[1;32mcreate a new lead\033[0m, type: \033[1;33m'New Lead'\033[0m. You will be prompted to input the information necessary to create the lead instance.
                - To \033[1;32mlookup a lead\033[0m, type: \033[1;33m'Lookup Lead ##'\033[0m, where '##' corresponds to the unique numeric identifier of the lead to show.
                - To \033[1;32m'show all leads\033[0m, type: \033[1;33m'Show Leads'\033[0m.
                - To \033[1;32mlookup leads by name\033[0m, type: \033[1;33m'Search Leads ####'\033[0m, where '####' corresponds to the first or last name you want to search.
                  The result will be a list of Leads with names containing the name introduced.
                
                > Opportunities 
                - To \033[1;32mconvert a lead into an opportunity\033[0m, type: \033[1;33m'convert ##'\033[0m, where '##' corresponds to the unique numeric identifier of the lead to convert.
                  You will be prompted to input the info necessary to create an ooportunity instance and an account instance.
                - To \033[1;32mshow all opportunities\033[0m, type: \033[1;33m'Show Opportunities'\033[0m.
                - To \033[1;32mlookup an opportunity\033[0m, type: \033[1;33m'Lookup-opp ##'\033[0m, where '##' corresponds to the unique numeric identifier of the opportunity. 
                - To \033[1;32mchange the status of an opportunity\033[0m, type: \033[1;33m'close-won ##' or 'close-lost ##'\033[0m, 
                  where '##' corresponds to the unique numeric identifier of the opportunity to modify.
                  
                > Accounts
                - To \033[1;32mshow all accounts\033[0m, type: \033[1;33m'Show Accounts'\033[0m.
                
                > Contacts
                - To \033[1;32mshow all contacts\033[0m, type: \033[1;33m'Show Contacts'\033[0m.
                
                > Reports
                - To \033[1;32mcount opportunites by product\033[0m, type: \033[1;33m'Report Opportunity by product ###'\033[0m. Where '####' corresponds to the name of the product. 
                
                > Other  
                - To \033[1;32mshow this list of commands \033[0m, type: \033[1;33m'show commands'\033[0m. 
                                
                ============= ======== ===== === == = =
                
                """);
    }



}
