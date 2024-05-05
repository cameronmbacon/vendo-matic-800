package com.techelevator.constructs.menu;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import com.techelevator.util.*;

import java.util.*;

public class PurchaseMenu extends Menu {
    private Map<Integer, String> selectionOptions = new LinkedHashMap<>();

    private String selectionOptionOne = "Feed Money";
    private String selectionOptionTwo = "Select Product";
    private String selectionOptionThree = "Finish Transaction";

    public PurchaseMenu() {
        super("Purchase Menu");
        setupSelectionOptions();
    }

    public void displaySelectionPrompt() {Menu.displayMenuSelectionPrompt(); }

    @Override
    public void displayStartingMenu() {
        System.out.println( "--------------" + this.menuTitle + "---------------");
        System.out.println();
        System.out.print(GeneralMessages.CURRENT_FUNDS_MESSAGE.getGeneralMessage());
        System.out.println(new TransactionRecorder()
                .formatPriceToString(VendingMachine.getInstance().getCustomerMoneyDepositBalance()));
        System.out.println();
        System.out.println();

        for (Map.Entry<Integer, String> menuSelection : selectionOptions.entrySet()) {
            Integer menuNumber = menuSelection.getKey();
            String menuOptionValue = menuSelection.getValue();
            DelayGenerator.excecuteOneFourthSecondDelay();
            System.out.println("(" + menuNumber + ") " + menuOptionValue);
        }

        System.out.println();
        System.out.println();
        DelayGenerator.excecuteHalfSecondDelay();
    }

    public void displayProductSelectionPrompt() {
        System.out.println(PromptMessages.PRODUCT_SELECTION_PROMPT.getPromptMessage());
    }
    public void displayMoneyDepositPrompt() {
        System.out.println(PromptMessages.DEPOSIT_MONEY_PROMPT.getPromptMessage());
    }
    public void displayContinuetoDepositPrompt() {
        System.out.println(PromptMessages.CONTINUE_TO_DEPOSIT_PROMPT.getPromptMessage());
    }

    public void displayPurchasedItemDetails(String purchaseItemLogData, Item itemPurchased) {
        System.out.println(GeneralMessages.ITEM_DISPENSED_MESSAGE.getGeneralMessage());
        DelayGenerator.excecuteFourSecondDelay();
        DisplayUtils.displayLineFormatPrints();
        System.out.println("Money Remaining: $" +  new TransactionRecorder()
                .formatPriceToString(VendingMachine.getInstance().getCustomerMoneyDepositBalance()));
        DisplayUtils.displayLineFormatPrints();
        DelayGenerator.excecuteTwoSecondDelay();
        System.out.println(purchaseItemLogData);
        DisplayUtils.displayLineFormatPrints();
        DelayGenerator.excecuteTwoSecondDelay();
        displayItemSpecificMessage(itemPurchased);
        DisplayUtils.displayLineFormatPrints();
        DelayGenerator.excecuteThreeSecondDelay();
        System.out.println(GeneralMessages.PURCHASE_MENU_LOADING_MESSAGE.getGeneralMessage());
        DelayGenerator.excecuteFourSecondDelay();
        DisplayUtils.displayLineFormatPrints();
        DisplayUtils.displayMenuFormatPrints();
    }

    private void displayItemSpecificMessage(Item itemPurchase) {

        switch (itemPurchase.getProductType()) {
            case CHIP:
                System.out.println(ItemSpecificMessages.CHIP_PURCHASE_MESSAGE.getItemMessage());
                break;
            case CANDY:
                System.out.println(ItemSpecificMessages.CANDY_PURCHASE_MESSAGE.getItemMessage());
                break;
            case DRINK:
                System.out.println(ItemSpecificMessages.DRINK_PURCHASE_MESSAGE.getItemMessage());
                break;
            case GUM:
                System.out.println(ItemSpecificMessages.GUM_PURCHASE_MESSAGE.getItemMessage());
                break;
        }
    }

    public void displayReturnChangeDetails(double remainingChange) {
        int quarters = (int) (remainingChange / 0.25);
        remainingChange %= 0.25;

        int dimes = (int) (remainingChange / 0.10);
        remainingChange %= 0.10;

        int nickels = (int) (remainingChange / 0.05);

        int pennies = (int) Math.round(remainingChange / 0.01);

        System.out.println(GeneralMessages.CHANGE_RETURNED_MESSAGE.getGeneralMessage());
        System.out.println();
        System.out.print("Quarters: " + quarters + " | ");
        System.out.println("Dimes: " + dimes);
        System.out.print("Nickels: " + nickels + " | ");
        System.out.println("Pennies: " + pennies);
    }


    public void setupSelectionOptions() {
        this.selectionOptions.put(1, selectionOptionOne);
        this.selectionOptions.put(2, selectionOptionTwo);
        this.selectionOptions.put(3, selectionOptionThree);
    }

    public Map<Integer, String> getSelectionOptions() {
        return selectionOptions;
    }
}
