package com.ironhack.crm.services;

import com.ironhack.crm.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final Scanner userInput;

    public AccountService(AccountRepository accountRepository, Scanner userInput) {
        this.accountRepository = accountRepository;
        this.userInput = userInput;
    }

}
