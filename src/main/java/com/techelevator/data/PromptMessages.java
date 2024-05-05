package com.techelevator.data;

public enum PromptMessages {
    MENU_SELECTION_PROMPT("Enter a selection: "),
    PRODUCT_SELECTION_PROMPT("Select a product: "),
    DEPOSIT_MONEY_PROMPT("Enter amount to deposit: "),
    CONTINUE_TO_DEPOSIT_PROMPT("Would you like to deposit more? ");

    private final String promptMessage;

    PromptMessages(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }
}
