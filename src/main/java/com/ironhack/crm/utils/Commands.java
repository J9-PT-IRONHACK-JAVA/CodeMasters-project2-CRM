package com.ironhack.crm.utils;

import org.springframework.stereotype.Component;

@Component
public class Commands {

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

}
