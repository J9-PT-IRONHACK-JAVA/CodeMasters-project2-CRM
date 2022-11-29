package com.ironhack.crm.services;

import com.ironhack.crm.model.Lead;
import com.ironhack.crm.utils.InputValidations;

import java.util.Scanner;

public class LeadService {

    public static Lead createNewLead(Scanner scanner) {
        String leadName = null;
        String phoneNumber = null;
        String email = null;
        String companyName = null;

        while (leadName == null) {
            System.out.println("Please introduce the name of your new lead\n");

            if (scanner.hasNextLine()) {
                if (!InputValidations.validateName(scanner.nextLine())) {
                    System.out.println("Wrong input. \n");
                } else leadName = scanner.nextLine();

            }
        }

        while (phoneNumber == null) {
            System.out.println("Please introduce the phone number of your new lead\n");

            if (scanner.hasNextLine()) {
                if (!InputValidations.validatePhone(scanner.nextLine())) {
                    System.out.println("Wrong input. \n");
                } else phoneNumber = scanner.nextLine();
            }
        }

        while (email == null) {
            System.out.println("Please introduce the email address of your new lead\n");

            if (scanner.hasNextLine()) {
                if (!InputValidations.validateEmail(scanner.nextLine())) {
                    System.out.println("Wrong input. \n");
                } else email = scanner.nextLine();
            }
        }

        while (companyName == null) {
            System.out.println("Please introduce the Company Name of your new lead\n");

            if (scanner.hasNextLine()) companyName = scanner.nextLine();
        }

        Lead newLead = new Lead(leadName, phoneNumber, email, companyName);

        return newLead;
    }
}
