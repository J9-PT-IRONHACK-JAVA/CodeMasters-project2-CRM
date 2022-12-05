package com.ironhack.crm.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    private int employees;
    private String city;
    private String country;

    public Account(String companyName, String industry, int employees, String city, String country) {
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployees(employees);
        setCity(city);
        setCountry(country);
    }
}
