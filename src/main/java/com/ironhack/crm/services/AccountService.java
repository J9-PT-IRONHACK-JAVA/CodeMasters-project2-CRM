package com.ironhack.crm.services;

import com.ironhack.crm.model.Account;
import com.ironhack.crm.model.Contact;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.repository.AccountRepository;
import com.ironhack.crm.utils.InputValidations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final Scanner userInput;

    public AccountService(AccountRepository accountRepository, Scanner userInput) {
        this.accountRepository = accountRepository;
        this.userInput = userInput;
    }

    public Account createAccountFromLead(Contact contact, Opportunity opportunity) {

        String industry = null;
        Integer employees = null;
        String city = null;
        String country = null;
        List<Contact> contacts = new ArrayList<>();
        List<Opportunity> opportunities = new ArrayList<>();

        var companyName = contact.getCompany();
        contacts.add(contact);
        opportunities.add(opportunity);

        while (industry == null || industry.equals("")) {
            System.out.println("Please introduce the \033[1;34mindustry\033[0m of your lead's company: " + companyName);

            var input= userInput.nextLine();

            if (!InputValidations.validateLettersOnly(input)) {
                System.out.println("Wrong input. Please introduce an industry. No numbers or special characters allowed.\n");

            } else industry = input;
        }

        while (employees == null) {
            System.out.println("Please introduce the \033[1;34mnumber of employees\033[0m of your lead's company: " + companyName);

            try {
                employees = Integer.valueOf(userInput.nextLine());

            } catch (Exception e) {
                System.out.println("Wrong input. Please introduce an integer number.\n");
                e.getMessage();
            }
        }

        while (city == null || city.equals("")) {
            System.out.println("Please introduce the \033[1;34mcity\033[0m where the Head Quarters of your lead's company: " + companyName + " is located.");

            var input= userInput.nextLine();

            if (!InputValidations.validateCityOrCountry(input)) {
                System.out.println("Wrong input. Please introduce a city name. No numbers or special characters allowed.\n");

            } else city = input;
        }

        while (country == null || country.equals("")) {
            System.out.println("Please introduce the \033[1;34mcountry\033[0m where the Head Quarters of your lead's company: " + companyName + " is located.");

            var input= userInput.nextLine();

            if (!InputValidations.validateCityOrCountry(input)) {
                System.out.println("Wrong input. Please introduce a country name. No numbers or special characters allowed.\n");

            } else country = input;
        }

        var newAccount = new Account(companyName,industry,employees,city,country,contacts,opportunities);
        accountRepository.save(newAccount);

        return newAccount;
    }

    public void showAllAccounts() {
        var accounts = accountRepository.findAll();
        System.out.println(accounts);
    }

}
