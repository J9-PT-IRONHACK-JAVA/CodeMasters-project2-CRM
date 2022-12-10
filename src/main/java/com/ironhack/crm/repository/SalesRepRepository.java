package com.ironhack.crm.repository;

import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.utils.Trucks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    static Integer countLeadBySalesRep(String salesRepName) {
        return null;
    }

    static Integer countOpportunitiesBySalesRep(String salesRepName) {
        return null;
    }
    static Integer closedWonOpportunitiesBySalesRep(String salesRepName) {
        return null;
    }
    static Integer closedLostOpportunitiesBySalesRep(String salesRepName) {
        return null;
    }
    static Integer openOpportunitiesbySalesRep(String salesRepName) {
        return null;
    }
}
