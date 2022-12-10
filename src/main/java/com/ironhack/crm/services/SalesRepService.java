package com.ironhack.crm.services;

import com.ironhack.crm.model.SalesRep;
import com.ironhack.crm.repository.SalesRepRepository;
import com.ironhack.crm.utils.SalesRepStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class SalesRepService {

    private final SalesRepRepository salesRepRepository;
    private final Scanner userInput;

    public void salesRepLogOut() {
        var loggedRep = salesRepRepository.findSalesRepByStatusIs(SalesRepStatus.ONLINE).get(0);

        loggedRep.setStatus(SalesRepStatus.DISCONNECTED);

        System.out.println("SalesRep " + loggedRep.getSalesRepName() + " is now " + loggedRep.getStatus() +
                "\n" + "... to close the application, type 'exit'.");
    }

    public Boolean salesRepLogin() {


        System.out.println("Please proceed to log-in...\n" + "Enter your full name: ");

        //variable to easily re-use the scanner
        var nameInput = userInput.nextLine();

        String nameToValidate = nameInput;
        Boolean isNameValidated = false;

        //name validation
        while (!isNameValidated) {

            try {
                if (salesRepRepository.findSalesRepBySalesRepName(nameToValidate).get(0) == null) {
                    System.out.println("No SalesRep found under that name, please try again.");
                }
                isNameValidated = true;

            } catch (Exception e) {
                System.out.println("Exception - wrong name, please try again");
            }
        }




        //email validation
        System.out.println("Hi, " + nameToValidate + ". Please introduce your email: ");
        var emailInput = userInput.nextLine();
        var emailToValidate = emailInput;
//        Optional<SalesRep> repWithEmail = null;
        var repWithEmail = salesRepRepository.findSalesRepBySalesRepEmail(emailToValidate);
        while (repWithEmail.isEmpty()) {
            System.out.println("No SalesRep linked to that email, please try again.");
            emailToValidate = emailInput;
        }
//        do {
//            var repWithEmail = salesRepRepository.findSalesRepBySalesRepEmail(emailToValidate);
//
//            if (repWithEmail.isEmpty()) {
//                System.out.println("No SalesRep linked to that email, please try again.");
//            }
//            try {
//                repWithEmail = salesRepRepository.findSalesRepBySalesRepEmail(emailToValidate);
//            } catch (Exception e) {
//                System.out.println("No SalesRep linked to that email, please try again.");
//                e.getMessage();
//            }

//        } while (repWithEmail.isEmpty());

        // password validation
        System.out.println("Please introduce your password: ");
        var passwordInput = userInput.nextLine();
        var passwordToValidate = passwordInput;
        Boolean isPasswordValidated = false;



        if (repWithEmail.get().getSalesRepEmail().equals(emailToValidate)) {
            isPasswordValidated = true;
            repWithEmail.get().setStatus(SalesRepStatus.ONLINE);
            System.out.println("The salesRep " + repWithEmail.get().getSalesRepName() + " is now " + repWithEmail.get().getStatus());
        } else {
            System.out.println("The password does not match the salesRep linked to the selected email. Please try again.");
        }

        return isPasswordValidated;
    }


}
