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
    public static String country;
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

    @Override
    public String toString() {
        return "Account:"
                + " id=" + id + "\n"
                + " companyName= " + companyName + "\n"
                + " industry= " + industry + "\n"
                + " employees= " + employees + "\n"
                + " city= " + city + "\n"
                + " country= " + country + "\n" +
//                + " contacts= " + contacts + "\n"
//                + " opportunities=" + opportunities + "\n" +
                "======== ===== === == = =" + "\n";
    }
}
