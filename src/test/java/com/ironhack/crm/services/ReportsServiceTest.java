package com.ironhack.crm.services;

import com.ironhack.crm.CrmApplication;
import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.repository.*;
import com.ironhack.crm.utils.Trucks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class ReportsServiceTest {

    @MockBean
    CrmApplication crmApplication;

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void opportunitiesByProduct() {
        var count = opportunityRepository.countOpportunitiesByProduct(Trucks.FLATBED);

        assertEquals(1, count);

    }
}