package com.ironhack.crm.services;

import com.ironhack.crm.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final AccountRepository accountRepository;

    public ContactService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



}
