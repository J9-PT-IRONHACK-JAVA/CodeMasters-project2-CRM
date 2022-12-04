package com.ironhack.crm.model;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class Account {
    private String companyName;
    private String industry;
    private int employees;
    private String city;
    private String country;
}
