package com.ironhack.crm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Lead {

    private static int id = 0;
    private int leadId;

    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;

    public Lead(String name, int phoneNumber, String email, String companyName) {
        setLeadId(id++);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    // Method to get the general ID of LEAD (not the object id)
//    public static int getId() {
//        return id;
//    }
}
