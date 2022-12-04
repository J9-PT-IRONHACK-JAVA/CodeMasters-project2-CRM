package com.ironhack.crm.services;

import com.ironhack.crm.repository.SalesRepRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesRepService {

    private final SalesRepRepository salesRepRepository;

    public SalesRepService(SalesRepRepository salesRepRepository) {
        this.salesRepRepository = salesRepRepository;
    }


}
