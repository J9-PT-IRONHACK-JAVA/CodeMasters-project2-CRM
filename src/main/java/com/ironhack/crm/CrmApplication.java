package com.ironhack.crm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
