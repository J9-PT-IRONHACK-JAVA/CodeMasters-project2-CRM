package com.ironhack.crm.repository;

import com.ironhack.crm.model.Opportunity;
import com.ironhack.crm.utils.Trucks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

  Optional<Opportunity> findOpportunityByOpportunityId(Long id);

  Integer countOpportunitiesByProduct(Trucks product);

//  @Query(value = " ", nativeQuery = true)
//  Integer countOpportunitiesByCountry(String country);

}
