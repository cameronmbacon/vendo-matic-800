package com.techelevator.data;

public enum GeneralMessages {
    DISPLAYING_ITEMS_MESSAGE("Displaying Vending Machine Items: "),
    PURCHASE_MENU_LOADING_MESSAGE("MESSAGE: Purchase Menu loading... "),
    HIDDEN_MENU_LOADING_MESSAGE("MESSAGE: ......loading... "),
    SALES_REPORT_LOADING_MESSAGE("MESSAGE: Loading Sales Report data... "),
    MAIN_MENU_LOADING_MESSAGE("MESSAGE: Main Menu Menu loading... "),
    FINISH_TRANSACTION_MESSAGE("UPDATE: TRANSACTION COMPLETED"),
    FEED_MONEY_MESSAGE("Enter amount of money to deposit: "),
    FUNDS_DEPOSIT_MESSAGE("UPDATE: Funds added to balance"),
    ITEM_OUT_OF_STOCK_MESSAGE("MESSAGE: ITEM IS OUT OF STOCK"),
    ALREADY_IN_HIDDEN_MENU_ERROR("ERROR: ALREADY IN HIDDEN MENU"),
    DISPENSE_ITEM_MESSAGE("UPDATE: Dispensing item..."),
    ADD_MORE_FUNDS_MESSAGE("MESSAGE: (Y)es or (N)o to add more funds: "),
    ITEM_DISPENSED_MESSAGE("UPDATE: Item Dispensed - Purchase Complete"),
    SELECT_PRODUCT_MESSAGE("Select Product: "),
    CANCEL_OPTION_MESSAGE("MESSAGE: Enter 'cancel to return to menu options'"),
    CHANGE_RETURNED_MESSAGE("MESSAGE: Change Returned:"),
    CURRENT_FUNDS_MESSAGE("Current Money Provided(max limit $20): $"),
    ITEMS_LOADING_MESSAGE("MESSAGE: Loading vending machine items..."),
    GENERATE_SALES_REPORT_MESSAGE("MESSAGE: Generating Sales Report loading... "),
    EXIT_VENDING_MACHINE_MESSAGE("MESSAGE: Exiting Vending Machine...");

    private final String generalMessage;

    GeneralMessages(String generalMessage) {
        this.generalMessage = generalMessage;
    }

    public String getGeneralMessage() {
        return generalMessage;
    }
}
