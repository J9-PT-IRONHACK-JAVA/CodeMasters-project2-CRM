package com.ironhack.crm.utils;

import com.ironhack.crm.repository.SalesRepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InputValidations {

    private final SalesRepRepository salesRepRepository;

    public static boolean validateName(String name) {
        Boolean isValidated = null;

        String[] nameCheck = name.split(" ");

        if (nameCheck.length != 2) {
            isValidated = false;
        } else isValidated = true;

        return isValidated;
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
    }

    public static boolean validateEmail(String email){
        return email.matches("^(.+)@(.+)$");
    }

    public static boolean validateLettersOnly(String industry) {
        return industry.matches("^[a-zA-Z\s]+$");
    }

    public static boolean validateCityOrCountry(String location) {
        return location.matches("^[a-zA-Z][a-zA-Z\\\\s-]+[a-zA-Z]$");
    }


}
