package com.ironhack.crm.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }


    @Override
    public String toString() {
        return "Lead: \n" +
                "   id= " + leadId + "\n" +
                "   name= " + name + "\n" +
                "   phoneNumber= " + phoneNumber + "\n" +
                "   email= " + email + "\n" +
                "   companyName= " + companyName + "\n";
    }
}
