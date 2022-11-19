package com.ironhack.crm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Contact {

    private static int id = 0;
    private int contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String company;

    public Contact(String name, String phoneNumber, String email, String company) {
        setContactId(id++);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompany(company);
    }
}
