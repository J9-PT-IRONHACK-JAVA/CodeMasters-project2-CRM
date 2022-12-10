package com.ironhack.crm.services;

import com.ironhack.crm.CrmApplication;
import com.ironhack.crm.model.Lead;
import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.repository.LeadRepository;
import com.ironhack.crm.repository.LeadRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadServiceTest {

    @MockBean
    CrmApplication crmApplication;

    @Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
       var lucho = new Lead("Lucho Padrique", "+34 765456879", "lucho@email.com", "La Roja",
               new SalesRep("Juana Gomez", "juana.gomez@email.com", "123456"));
        leadRepository.save(lucho);
    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void createNewLead() {
        var pepe = new Lead("Pepe Frog", "+34 658123539", "pepe@email.com", "Swamp",
                new SalesRep("Juana Gomez", "juana.gomez@email.com", "123456"));
        assertEquals("Swamp", pepe.getCompanyName());
    }

    @Test
    void convertLeadToContact() {
        var lucho = leadRepository.findLeadByNameContaining("Lucho");
        var contact = leadService.convertLeadToContact(lucho.get(0).getLeadId());
        assertEquals("La Roja", contact.getCompany());
    }

    @Test
    void leadToOpportunity() {
        var lucho = leadRepository.findAll().get(0);

    }

//    @Test
//    void findLeadsByName() {
//    }
//
//    @Test
//    void showAllLeads() {
//    }
//
//    @Test
//    void deleteLead() {
//    }
}