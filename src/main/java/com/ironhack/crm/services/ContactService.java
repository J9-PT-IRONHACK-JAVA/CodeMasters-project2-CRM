package com.ironhack.crm.services;

import com.ironhack.crm.model.Contact;
import com.ironhack.crm.repository.AccountRepository;
import com.ironhack.crm.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

        public void findAllContacts() {
        var contacts = contactRepository.findAll();
        System.out.println(contacts);
    }
}
