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

    public Contact(Lead lead) {
        setContactId(id++);
        setName(lead.getName());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        setCompany(lead.getCompanyName());
    }
}
