package com.ironhack.crm.repository;

import com.ironhack.crm.CrmApplication;
import com.ironhack.crm.model.Lead;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LeadRepositoryTest {

    @MockBean
    CrmApplication crmApplication;

    @Autowired
    private LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
        var lucho = new Lead("Lucho Padrique", "+34 613456123", "padrique@email.com", "La Roja");
        leadRepository.save(lucho);
        var pepe = new Lead("Pepe Frog", "+34 675890765", "pepefrog@email.com", "Swamp");
        leadRepository.save(pepe);
    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void findLeadByLeadId() {
        var second = leadRepository.findLeadByLeadId(2L);
        if (second.isPresent()) {
            assertEquals("Pepe Frog", second.get().getName());
        }
    }

    @Test
    void findLeadByNameContaining() {
        var padrique = leadRepository.findLeadByNameContaining("Padrique");
        assertEquals("La Roja", padrique.get(0).getCompanyName());
    }

    @Test
    void deleteLeadByLeadId() {
        var leadId = leadRepository.findAll().get(0).getLeadId();
        leadRepository.deleteLeadByLeadId(leadId);
        var allLeads = leadRepository.findAll();
        assertEquals(1, allLeads.size());
    }
}