package com.ironhack.crm.repository;

import com.ironhack.crm.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

  Opportunity findOpportunityByOpportunityId(Long id);
}
