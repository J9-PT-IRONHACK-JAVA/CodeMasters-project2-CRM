package com.ironhack.crm.utils;

import org.springframework.stereotype.Component;

@Component
public class Commands {

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
                - To \033[1;32mshow the available reports\033[0m, type: \033[1;33m'Show Reports'\033[0m. 
                
                > Other  
                - To \033[1;32mshow this list of commands \033[0m, type: \033[1;33m'show commands'\033[0m. 
                                
                ============= ======== ===== === == = =
                
                """);
    }


    public void displayAvailableReports() {
        System.out.println("""
                ============= ======== ===== === == = ="

                \033[1;31mIMPORTANT\033[0m 
                \033[1;31mThe commands are Case-Sensitive!\033[0m

                You have the following \033[1;32reports available:\033[0m
                > By SalesRep
                - To see a \033[1;32mcount of Leads by SalesRep\033[0m, type: \033[1;33m'Report Lead by SalesRep'\033[0m.
                - To see a \033[1;32mcount of Opportunities by SalesRep\033[0m, type: \033[1;33m'Report Opportunity by SalesRep'\033[0m.
                - To see a \033[1;32mcount of CLOSED-WON Opportunities by SalesRep\033[0m, type: \033[1;33m'Report CLOSED-WON by SalesRep'\033[0m.
                - To see a \033[1;32mcount of CLOSED-LOST Opportunities by SalesRep\033[0m, type: \033[1;33m'Report CLOSED-LOST by SalesRep'\033[0m.
                - To see a \033[1;32mcount of OPEN Opportunities by SalesRep\033[0m, type: \033[1;33m'Report OPEN by SalesRep'\033[0m.
                
                > By Product 
                - To see a \033[1;32mcount of opportunites by product\033[0m, type: \033[1;33m'Report Opportunity by product\033[0m.
                - To see a \033[1;32mcount of CLOSED-WON opportunites by product\033[0m, type: \033[1;33m'Report CLOSED-WON by product\033[0m.
                - To see a \033[1;32mcount of CLOSED-LOST opportunites by product\033[0m, type: \033[1;33m'Report CLOSED-LOST by product\033[0m.
                - To see a \033[1;32mcount of OPEN opportunites by product\033[0m, type: \033[1;33m'Report OPEN by product\033[0m.
                  
                > By Country
                - To see a \033[1;32mcount of opportunites by country\033[0m, type: \033[1;33m'Report Opportunity by country\033[0m.
                - To see a \033[1;32mcount of CLOSED-WON opportunites by country\033[0m, type: \033[1;33m'Report CLOSED-WON by cuontry\033[0m.
                - To see a \033[1;32mcount of CLOSED-LOST opportunites by country\033[0m, type: \033[1;33m'Report CLOSED-LOST by country\033[0m.
                - To see a \033[1;32mcount of OPEN opportunites by country\033[0m, type: \033[1;33m'Report OPEN by country\033[0m.
                
                > By City
                - To see a \033[1;32mcount of opportunites by city\033[0m, type: \033[1;33m'Report Opportunity by city\033[0m.
                - To see a \033[1;32mcount of CLOSED-WON opportunites by city\033[0m, type: \033[1;33m'Report CLOSED-WON by city\033[0m.
                - To see a \033[1;32mcount of CLOSED-LOST opportunites by city\033[0m, type: \033[1;33m'Report CLOSED-LOST by city\033[0m.
                - To see a \033[1;32mcount of OPEN opportunites by city\033[0m, type: \033[1;33m'Report OPEN by city\033[0m.
                
                > By Industry
                - To see a \033[1;32mcount of opportunites by industry\033[0m, type: \033[1;33m'Report Opportunity by industry\033[0m.
                - To see a \033[1;32mcount of CLOSED-WON opportunites by industry\033[0m, type: \033[1;33m'Report CLOSED-WON by industry\033[0m.
                - To see a \033[1;32mcount of CLOSED-LOST opportunites by industry\033[0m, type: \033[1;33m'Report CLOSED-LOST by industry\033[0m.
                - To see a \033[1;32mcount of OPEN opportunites by industry\033[0m, type: \033[1;33m'Report OPEN by industry\033[0m.
                
                > By Employee Count 
                - To see the \033[1;32mmean of employeeCount\033[0m, type: \033[1;33m'Mean employeeCount\033[0m.
                - To see the \033[1;32mmedian of employeeCount\033[0m, type: \033[1;33m'Median employeeCount\033[0m.
                - To see the \033[1;32mmaximum of employeeCount\033[0m, type: \033[1;33m'Max employeeCount\033[0m.
                - To see the \033[1;32mminimum of employeeCount\033[0m, type: \033[1;33m'Min employeeCount\033[0m.
                
                > By Quantity 
                - To see the \033[1;32mmean of quantity\033[0m, type: \033[1;33m'Mean quantity\033[0m.
                - To see the \033[1;32mmedian of quantity\033[0m, type: \033[1;33m'Median quantity\033[0m.
                - To see the \033[1;32mmaximum of quantity\033[0m, type: \033[1;33m'Max quantity\033[0m.
                - To see the \033[1;32mminimum of quantity\033[0m, type: \033[1;33m'Min quantity\033[0m.
                
                > By Opportunity 
                - To see the \033[1;32mmean number of Opportunities associated with an Account\033[0m, type: \033[1;33m'Mean Opps per account\033[0m.
                - To see the \033[1;32mmedian number of Opportunities associated with an Account\033[0m, type: \033[1;33m'Median Opps per account\033[0m.
                - To see the \033[1;32mmaximum number of Opportunities associated with an Account\033[0m, type: \033[1;33m'Max Opps per account\033[0m.
                - To see the \033[1;32mminimum number of Opportunities associated with an Account\033[0m, type: \033[1;33m'Min Opps per account\033[0m.
                                
                ============= ======== ===== === == = =
                
                """);
    }



}
