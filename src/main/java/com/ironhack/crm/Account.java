package com.ironhack.crm;

import java.util.ArrayList;

public class Account {
    int accountID;
    String accountIndustry;
    int accountNumberOfEmployees;
    String accountCountry;
    String accountCity;
    String accountCompanyName;
    ArrayList accountListOfContacts;
    ArrayList accountListOfOpportunities;

    public Account(int accountID, String accountIndustry, int accountNumberOfEmployees, String accountCountry, String accountCity, String accountCompanyName, ArrayList accountListOfContacts, ArrayList accountListOfOpportunities) {
        this.accountID = accountID;
        this.accountIndustry = accountIndustry;
        this.accountNumberOfEmployees = accountNumberOfEmployees;
        this.accountCountry = accountCountry;
        this.accountCity = accountCity;
        this.accountCompanyName = accountCompanyName;
        this.accountListOfContacts = accountListOfContacts;
        this.accountListOfOpportunities = accountListOfOpportunities;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountIndustry() {
        return accountIndustry;
    }

    public void setAccountIndustry(String accountIndustry) {
        this.accountIndustry = accountIndustry;
    }

    public int getAccountNumberOfEmployees() {
        return accountNumberOfEmployees;
    }

    public void setAccountNumberOfEmployees(int accountNumberOfEmployees) {
        this.accountNumberOfEmployees = accountNumberOfEmployees;
    }

    public String getAccountCountry() {
        return accountCountry;
    }

    public void setAccountCountry(String accountCountry) {
        this.accountCountry = accountCountry;
    }

    public String getAccountCity() {
        return accountCity;
    }

    public void setAccountCity(String accountCity) {
        this.accountCity = accountCity;
    }

    public String getAccountCompanyName() {
        return accountCompanyName;
    }

    public void setAccountCompanyName(String accountCompanyName) {
        this.accountCompanyName = accountCompanyName;
    }

    public ArrayList getAccountListOfContacts() {
        return accountListOfContacts;
    }

    public void setAccountListOfContacts(ArrayList accountListOfContacts) {
        this.accountListOfContacts = accountListOfContacts;
    }

    public ArrayList getAccountListOfOpportunities() {
        return accountListOfOpportunities;
    }

    public void setAccountListOfOpportunities(ArrayList accountListOfOpportunities) {
        this.accountListOfOpportunities = accountListOfOpportunities;
    }
}
