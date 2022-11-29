package com.ironhack.crm.utils;

public class InputValidations {

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

}
