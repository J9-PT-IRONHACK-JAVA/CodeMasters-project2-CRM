package com.ironhack.crm;

import com.ironhack.crm.repository.LeadRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CrmApplicationTests {

    @MockBean
    CrmApplication crmApplication;

    @Test
    void contextLoads() {
    }

}
