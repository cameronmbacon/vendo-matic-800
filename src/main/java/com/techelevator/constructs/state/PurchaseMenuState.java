package com.techelevator.constructs.state;

import com.techelevator.constructs.menu.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import com.techelevator.util.*;

public class PurchaseMenuState implements MenuState {
    private final static int MINIMUM_ITEM_QUANTITY = 0;
    private PurchaseMenu purchaseMenu;
    private CustomerInputValidator customerInputValidator = new CustomerInputValidator();
    private TransactionRecorder transactionRecorder = new TransactionRecorder();
    private SalesReport salesReport = VendingMachine.getInstance().getSalesReport();

    public PurchaseMenuState(PurchaseMenu purchaseMenu) {
        this.purchaseMenu = purchaseMenu;
    }

    public void displayMenu() {
        this.purchaseMenu.displayStartingMenu();
    }

    @Override
    public void handleCustomerInput(String customerInput) {
        if(customerInput.equals("1")) {
            System.out.println();
            executedFeedMoneyStage();
            DelayGenerator.excecuteThreeSecondDelay();
        }
        if(customerInput.equals("2")) {
            System.out.println(GeneralMessages.ITEMS_LOADING_MESSAGE.getGeneralMessage());
            DisplayUtils.displayLineFormatPrints();
            DelayGenerator.excecuteThreeSecondDelay();
            VendingMachine.getInstance().displayInventory();
            DisplayUtils.displayLineFormatPrints();
            executeProductSelectionStage();
        }

        if(customerInput.equals("3")) {
            System.out.println(GeneralMessages.FINISH_TRANSACTION_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteTwoSecondDelay();
            executeFinishedTransactionStage();
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteThreeSecondDelay();
            VendingMachine.getInstance().setState(new MainMenuState(new MainMenu()));
            System.out.println( GeneralMessages.MAIN_MENU_LOADING_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteFourSecondDelay();
        } if(customerInput.equals("4")) {
            if(customerInputValidator.validateSecretPasswordIsPassed()) {
                System.out.println();
                VendingMachine.getInstance().setState(new HiddenMenuState(new HiddenMenu()));
                System.out.println(GeneralMessages.HIDDEN_MENU_LOADING_MESSAGE.getGeneralMessage());
                DisplayUtils.displayMenuFormatPrints();
                DelayGenerator.excecuteFourSecondDelay();
            }
        }
    }

    private void executedFeedMoneyStage() {
        boolean inputIsValid = false;

        while(!inputIsValid) {
            System.out.print(GeneralMessages.CURRENT_FUNDS_MESSAGE.getGeneralMessage());
            System.out.println(transactionRecorder.formatPriceToString(VendingMachine.getInstance().getCustomerMoneyDepositBalance()));
            DisplayUtils.displayLineFormatPrints();
            System.out.println(GeneralMessages.CANCEL_OPTION_MESSAGE.getGeneralMessage());
            DisplayUtils.displayLineFormatPrints();
            System.out.print(GeneralMessages.FEED_MONEY_MESSAGE.getGeneralMessage());
            String depositFundsRequest = VendingMachine.getInstance().getMachineKeyPad().getCustomerInput();

            if(customerInputValidator.validateIfCancelWasRequested(depositFundsRequest)) {
                break;
            }

           inputIsValid = customerInputValidator.validateIfValidPositiveIntegerWasPassed(depositFundsRequest);

            if(inputIsValid) {
                inputIsValid = customerInputValidator.validateDepositRequestUnderMaxLimit(depositFundsRequest);
            }

            if(inputIsValid) {
                double currentFundsBalance = transactionRecorder
                        .formatPrice(VendingMachine.getInstance().getCustomerMoneyDepositBalance());
                VendingMachine.getInstance()
                        .setCustomerMoneyDepositBalance(transactionRecorder
                                .formatPrice(currentFundsBalance + (double) Integer.parseInt(depositFundsRequest)));
                System.out.println(GeneralMessages.FUNDS_DEPOSIT_MESSAGE.getGeneralMessage());

                double newTotal = transactionRecorder
                        .formatPrice(VendingMachine.getInstance().getCustomerMoneyDepositBalance());
                transactionRecorder.logCustomerFeedTransactions(currentFundsBalance, newTotal);
                DisplayUtils.displayLineFormatPrints();
                DelayGenerator.excecuteTwoSecondDelay();
            }

            if(inputIsValid) {
                System.out.print(GeneralMessages.ADD_MORE_FUNDS_MESSAGE.getGeneralMessage());
                DelayGenerator.excecuteTwoSecondDelay();
                String customerResponse = VendingMachine.getInstance().getMachineKeyPad().getCustomerInput();
                inputIsValid = customerInputValidator.validateIfAddMoreFundsIsFalse(customerResponse);
            }
        }
    }

    private void executeDisplayChangeDetails() {
        getPurchaseMenu().displayReturnChangeDetails(VendingMachine.getInstance().getCustomerMoneyDepositBalance());
    }

    private void executeFinishedTransactionStage() {
        executeDisplayChangeDetails();
        double currentChangeToReturn = transactionRecorder.formatPrice(VendingMachine.getInstance().getCustomerMoneyDepositBalance());
        VendingMachine.getInstance().setCustomerMoneyDepositBalance(0.00);

        transactionRecorder.logChangeTransactions(currentChangeToReturn, 0.00);
    }

    private void executeProductSelectionStage() {
        boolean inputIsValid = false;

        while(!inputIsValid) {
            System.out.print(GeneralMessages.CURRENT_FUNDS_MESSAGE.getGeneralMessage());
            System.out.println(transactionRecorder.formatPriceToString(VendingMachine.getInstance().getCustomerMoneyDepositBalance()));
            DisplayUtils.displayLineFormatPrints();
            System.out.println(GeneralMessages.CANCEL_OPTION_MESSAGE.getGeneralMessage());
            DisplayUtils.displayLineFormatPrints();
            System.out.print(GeneralMessages.SELECT_PRODUCT_MESSAGE.getGeneralMessage());
            String requestedItem = VendingMachine.getInstance().getMachineKeyPad().getCustomerInput().toUpperCase();

            if(customerInputValidator.validateIfCancelWasRequested(requestedItem)) {
                break;
            }

            inputIsValid = customerInputValidator.validateIfValidItemRequested(requestedItem);

            if(inputIsValid) {
                inputIsValid = customerInputValidator.validateCustomerHasEnoughMoneyToPurchase(requestedItem);
            } else {
                VendingMachine.getInstance().displayInventory();
                DisplayUtils.displayLineFormatPrints();
            }

            if(inputIsValid) {
                Item itemPurchased = transactionRecorder.retrieveItemDetails(requestedItem);
                String slotLocationName = itemPurchased.getSlotLocation();
                String selectedRowLetter = slotLocationName.split("")[0];
                SlotLocation selectedSlotLocation = VendingMachine.getInstance().getRows().get(selectedRowLetter).getSlot(slotLocationName);
                if (selectedSlotLocation.getQuantity() == MINIMUM_ITEM_QUANTITY) {
                    DelayGenerator.excecuteHalfSecondDelay();
                    System.out.println(GeneralMessages.ITEM_OUT_OF_STOCK_MESSAGE.getGeneralMessage());
                    DisplayUtils.displayLineFormatPrints();
                    DelayGenerator.excecuteTwoSecondDelay();
                    break;
                }
                selectedSlotLocation.vendItem();
                salesReport.addSale(itemPurchased.getProductName(), itemPurchased.getPrice());
                String purchaseItemLogData = transactionRecorder.logCustomerPurchaseTransactions(requestedItem);
                System.out.println(GeneralMessages.DISPENSE_ITEM_MESSAGE.getGeneralMessage());
                DisplayUtils.displayLineFormatPrints();
                DelayGenerator.excecuteFourSecondDelay();
                getPurchaseMenu().displayPurchasedItemDetails(purchaseItemLogData,itemPurchased);
            }
        }
    }

    public PurchaseMenu getPurchaseMenu() {
        return purchaseMenu;
    }

    @Override
    public void displayMenuStartingPrompt() {
        this.purchaseMenu.displaySelectionPrompt();
    }
}
