package com.ironhack.crm.services;

import com.ironhack.crm.model.Lead;
import com.ironhack.crm.repository.ContactRepository;
import com.ironhack.crm.repository.LeadRepository;
import com.ironhack.crm.repository.OpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadServiceTest {

    private final LeadService leadService;
    private final LeadRepository leadRepository;

    private final OpportunityRepository opportunityRepository;

    private final ContactRepository contactRepository;

    public LeadServiceTest(LeadService leadService, LeadRepository leadRepository,
                           OpportunityRepository opportunityRepository, ContactRepository contactRepository) {
        this.leadService = leadService;
        this.leadRepository = leadRepository;
        this.opportunityRepository = opportunityRepository;
        this.contactRepository = contactRepository;
    }

//    @Autowired
//    private LeadService leadService;
//    @Autowired
//    private LeadRepository leadRepository;
//    @Autowired
//    private OpportunityRepository opportunityRepository;
//    @Autowired
//    private ContactRepository contactRepository;


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
    void createNewLeadAndAddToRepo() {
        /* var initialCount = leadRepository.count();
        var lead2 = new Lead("Pepe Perez", "+34 666654321", "pepe.perez@fakemail.com",
                "Desatranques Jaen");
        leadRepository.save(lead2);
        var postCount = leadRepository.count();
        assertEquals(1, postCount - initialCount); */

    }


    @Test
    void leadToOpportunity() {
    }

    @Test
    void createNewLead() {
    }

    @Test
    void testConvertLeadToContact() {
        var lead3 = new Lead("Maria Gomez", "+34 666879321", "maria.gomez@fakemail.com",
                "Desatranques Jaen");
        leadRepository.save(lead3);
        Long lead3Id = lead3.getLeadId();
        var contact1 = leadService.convertLeadToContact(lead3Id);
        contactRepository.save(contact1);
        assertSame("Maria Gomez", contact1.getName());
    }

    @Test
    void testLeadToOpportunity() {
    }

    @Test
    void findLeadByName() {
    }

    @Test
    void showAllLeads() {
    }
}