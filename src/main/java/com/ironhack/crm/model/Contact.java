package com.ironhack.crm.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    private String name;
    private String phoneNumber;
    private String email;
    private String company;

    public Contact(Lead lead) {
        setName(lead.getName());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        setCompany(lead.getCompanyName());
    }

}
