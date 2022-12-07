package com.ironhack.crm.repository;

import com.ironhack.crm.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    Lead findLeadByLeadId(Long id);

    List<Lead> findLeadByNameContaining(String name);

    void deleteLeadByLeadId(Long id);

}
