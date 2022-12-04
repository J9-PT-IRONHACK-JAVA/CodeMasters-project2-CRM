package com.ironhack.crm.services;

import com.ironhack.crm.model.Lead;
import com.ironhack.crm.repository.LeadRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadServiceTest {

    @Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepository leadRepository;


    @BeforeEach
    void setUp() {
        var lead1 = new Lead("Mike Michaels", "+34 666123456", "mike.michaels@fakemail.com",
                "Desatranques Jaen");
        leadRepository.save(lead1);

    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void createNewLead() {
    }

    @Test
    void convertLeadToContact() {
        var lead2 = new Lead("Pepe Perez", "+34 666654321", "pepe.perez@fakemail.com",
                "Desatranques Jaen");
        leadRepository.save(lead2);
        Long lead2Id = lead2.getLeadId();
        var contact1 = leadService.convertLeadToContact(lead2Id);

        assertSame("Pepe Perez", contact1.getName());
    }

    @Test
    void leadToOpportunity() {
    }
}