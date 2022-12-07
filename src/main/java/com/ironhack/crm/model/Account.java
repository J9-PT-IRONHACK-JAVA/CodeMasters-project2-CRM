package com.ironhack.crm.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String industry;
    private Integer employees;
    private String city;
    private String country;
    @OneToMany
    private List<Contact> contacts;
    @OneToMany
    private List<Opportunity> opportunities;

    public Account(String companyName, String industry, Integer employees, String city, String country,
                   List<Contact> contacts, List<Opportunity> opportunities) {
        this.companyName = companyName;
        this.industry = industry;
        this.employees = employees;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.opportunities = opportunities;
    }


}
