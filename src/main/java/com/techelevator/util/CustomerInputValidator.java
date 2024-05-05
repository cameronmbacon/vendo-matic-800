package com.techelevator.util;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

public class CustomerInputValidator {

    public boolean validateIfInvalidIntegerWasPassed(String customerInput) {
        try {
            Integer.parseInt(customerInput);
            DelayGenerator.excecuteTwoSecondDelay();
            return false;
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: VALID NUMBER NOT ENTERED");
            DelayGenerator.excecuteOneSecondDelay();
            System.out.println();
            DelayGenerator.excecuteThreeSecondDelay();
            return true;
        }
    }

    public boolean validateIfValidPositiveIntegerWasPassed(String depositFundsRequest) {
        try {
            Integer.parseInt(depositFundsRequest);

            if(Integer.parseInt(depositFundsRequest) <= 0) {
                System.err.println("ERROR: MUST ENTER A POSITIVE NUMBER");
                DelayGenerator.excecuteTwoSecondDelay();
                DisplayUtils.displayLineFormatPrints();
                return false;
            }
            DelayGenerator.excecuteTwoSecondDelay();
            return true;
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: VALID WHOLE NUMBER NOT ENTERED");
            DelayGenerator.excecuteOneSecondDelay();
            DisplayUtils.displayLineFormatPrints();
            DelayGenerator.excecuteThreeSecondDelay();
            return false;
        } catch (Exception e) {
            System.out.println("ERROR: RESPONSE NOT RECOGNIZED ");
            DisplayUtils.displayLineFormatPrints();
            return false;
        }
    }


    public boolean validateIfValidMenuSelectionWasChosen(String customerInput) {
        boolean errorCaught = false;
        try {
            boolean validIntPassed = validateIfInvalidIntegerWasPassed(customerInput);
            errorCaught = validIntPassed;
            int convertedCustomerInput = Integer.parseInt(customerInput);
            if((convertedCustomerInput > 4) || (convertedCustomerInput < 0)) {
                System.err.println("ERROR: INVALID MENU SELECTION MADE");
                DelayGenerator.excecuteOneSecondDelay();
                DisplayUtils.displayLineFormatPrints();
                DelayGenerator.excecuteThreeSecondDelay();
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            if(!errorCaught) {
                return false;
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        return false;
    }

    public boolean validateCustomerSelection(String customerInput) {
        boolean isValidMenuSelection = validateIfValidMenuSelectionWasChosen(customerInput);
        return isValidMenuSelection;
    }

    public boolean validateIfValidItemRequested(String requestedItem) {
        if(VendingMachine.getInstance().getVendingMachineItems().containsKey(requestedItem) == true) {
            VendingMachine.getInstance().getVendingMachineItems().containsKey(requestedItem);
            DelayGenerator.excecuteOneSecondDelay();
            System.out.println();
            return true;
        } else {
            System.err.println("ERROR: PRODUCT SELECTION NOT FOUND");
            DisplayUtils.displayLineFormatPrints();
            return false;
        }
}

    public boolean validateCustomerHasEnoughMoneyToPurchase(String requestedItem) {
        try {
            double itemPrice = VendingMachine.getInstance().getVendingMachineItems().get(requestedItem).getPrice();
            if(itemPrice <= VendingMachine.getInstance().getCustomerMoneyDepositBalance()) {
                DelayGenerator.excecuteOneSecondDelay();
                return true;
            } else {
                System.err.println("ERROR: NOT ENOUGH FUNDS TO COMPLETE PURCHASE");
                DelayGenerator.excecuteTwoSecondDelay();
                return false;
            }
        } catch (NullPointerException ex) {
            System.err.println("ERROR: SYSTEM FAILURE ");
            DelayGenerator.excecuteTwoSecondDelay();
            return false;
        } catch (Exception e) {
            System.err.println("ERROR: SYSTEM ERROR CRASH");
            DelayGenerator.excecuteTwoSecondDelay();
            return false;
        }
    }

    public boolean validateIfCancelWasRequested(String customerRequest) {
        if(customerRequest.toLowerCase().equals("cancel")) {
            DelayGenerator.excecuteOneSecondDelay();
            System.out.println(GeneralMessages.PURCHASE_MENU_LOADING_MESSAGE.getGeneralMessage());
            System.out.println();
            System.out.println();
            DelayGenerator.excecuteFourSecondDelay();
            return true;
        } else {
            DelayGenerator.excecuteOneSecondDelay();
            return false;
        }
    }

    public boolean validateIfAddMoreFundsIsFalse(String customerResponse) {
        if(customerResponse.toLowerCase().equals("y") || customerResponse.toLowerCase().equals("yes")) {
            DisplayUtils.displayLineFormatPrints();
            return false;
        }
        DisplayUtils.displayLineFormatPrints();
        return true;
    }

    public boolean validateDepositRequestUnderMaxLimit(String depositFundsRequest) {
        double currentBalance = VendingMachine.getInstance().getCustomerMoneyDepositBalance();
        int totalPotentialBalance = (int) (currentBalance + Integer.parseInt(depositFundsRequest));
        if(Integer.parseInt(depositFundsRequest) <= 20 && totalPotentialBalance <= 20) {
            return true;
        }
        System.err.println("ERROR: TOTAL FUNDS WILL EXCEED DEPOSIT LIMIT");
        System.out.println();
        DelayGenerator.excecuteThreeSecondDelay();
        return false;
    }

    public boolean validateSecretPasswordIsPassed() {
        System.out.print("Enter password: ");
        String userInput = VendingMachine.getInstance().getMachineKeyPad().getCustomerInput();
        DisplayUtils.displayLineFormatPrints();
        if(userInput.toLowerCase().equals("$$$$$")) {
            return true;
        } else {
            System.err.println("ERROR: ACCESS DENIED");
            DisplayUtils.displayLineFormatPrints();
            return false;
        }
    }
}
