package com.ironhack.crm.services;

import com.ironhack.crm.model.Contact;
import com.ironhack.crm.model.Lead;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceManagerTest {

    @BeforeEach
    void setUp() {
        var lead1 = new Lead("Mike Michaels", "+34 666123456", "mike.michaels@fakemail.com",
                "Desatranques Jaen");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void displayAvailableCommands() {
    }

    @Test
    void leadToOpportunity() {
    }

    @Test
    void convertLeadToContact() {
        var lead2 = new Lead("Pepe Perez", "+34 666654321", "pepe.perez@fakemail.com",
                "Desatranques Jaen");
        var contact1 = ServiceManager.convertLeadToContact(lead2);

        assertSame("Pepe Perez", contact1.getName());

    }

    @Test
    void createOpportunity() {

    }
}