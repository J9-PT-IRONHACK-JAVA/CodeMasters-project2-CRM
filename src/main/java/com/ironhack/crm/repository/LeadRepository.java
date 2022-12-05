package com.ironhack.crm.repository;

import com.ironhack.crm.model.Lead;
import com.ironhack.crm.services.LeadService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    Lead findLeadByLeadId(Long id);
    Lead findLeadByNameEquals(String name);

}
