package com.ironhack.crm;

import com.ironhack.crm.services.MainMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {

    private final MainMenu mainMenu;

    public CrmApplication(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Override
    public void run(String... args) {
        mainMenu.start();
    }
}
