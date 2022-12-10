package com.ironhack.crm.repository;

import com.ironhack.crm.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface LeadRepository extends JpaRepository<Lead, Long> {

    Optional<Lead> findLeadByLeadId(Long id);

    List<Lead> findLeadByNameContaining(String name);

    void deleteLeadByLeadId(Long id);

}
