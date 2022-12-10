package com.ironhack.crm.repository;

import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.utils.SalesRepStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    List<SalesRep> findSalesRepBySalesRepName(String name);

//    List<SalesRep> findSalesRepByStatusIsSalesRepStatus_Online();
    List<SalesRep> findSalesRepByStatusIs(SalesRepStatus online);

    Optional<SalesRep> findSalesRepBySalesRepEmail(String email);

//    Object countLeadBySalesRep(String salesRepName);
//
//
//    Integer countOpportunitiesBySalesRep(String salesRepName);

//    Integer closedWonOpportunitiesBySalesRep(String salesRepName);

//    Integer closedLostOpportunitiesBySalesRep(String salesRepName);

//    Integer openOpportunitiesbySalesRep(String salesRepName);


}
