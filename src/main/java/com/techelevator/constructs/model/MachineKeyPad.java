package com.techelevator.constructs.model;

import com.techelevator.util.*;

import java.io.*;

public class MachineKeyPad {

    private BufferedReader bufferedReader;
    private VendingMachineHelper vendingMachineHelper = new VendingMachineHelper();

    private DelayGenerator delayGenerator = new DelayGenerator();

    public MachineKeyPad(InputStreamReader inputStreamReader) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getCustomerNumbderInput() {
        int customerSelectedInt = 0;
        boolean inputIsValid = false;

        while (!inputIsValid) {
            try {
                customerSelectedInt = Integer.parseInt(bufferedReader.readLine());
                System.out.println();
//                inputIsValid = CustomerInputValidator.validateIfValidMenuSelectionWasChosen(customerSelectedInt);
                System.out.println();
                if(inputIsValid == false) {
                    System.err.println("SELECTION INVALID: TRY AGAIN \n");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage() + " Please try again.");
                System.out.println();
                System.out.println();
                vendingMachineHelper.sendCustomerSelectionPrompt();
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage() + " Please enter a valid customerSelectedInt.");
                System.out.println();
                System.out.println();
                vendingMachineHelper.sendCustomerSelectionPrompt();
            }
        }
        return customerSelectedInt;
    }

    public String getCustomerInput() {
        String customerSelectedInt = "";

        try {
            customerSelectedInt = bufferedReader.readLine();
            delayGenerator.excecuteOneSecondDelay();
            System.out.println();
        } catch (IOException e) {
            delayGenerator.excecuteTwoSecondDelay();
            System.err.println(e.getMessage() + " Please try again.");
            System.out.println();
        }

        return customerSelectedInt;
    }

}
