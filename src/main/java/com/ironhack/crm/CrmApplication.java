package com.ironhack.crm;

import com.ironhack.crm.services.MainMenu;
import com.ironhack.crm.services.SalesRepService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CrmApplication implements CommandLineRunner {

    private final MainMenu mainMenu;
    private final SalesRepService salesRepService;

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Override
    public void run(String... args) {
        while (!salesRepService.salesRepLogin()) {
            salesRepService.salesRepLogin();
        }
        mainMenu.commandsReceptor();
    }
}
