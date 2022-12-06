package com.ironhack.crm.repository;

import com.ironhack.crm.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

  Optional<Opportunity> findOpportunityByOpportunityId(Long id);
}
