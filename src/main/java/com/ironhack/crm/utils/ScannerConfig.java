package com.ironhack.crm.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ScannerConfig {

    @Bean
    Scanner userInput(){
        return new Scanner(System.in);
    }

}
