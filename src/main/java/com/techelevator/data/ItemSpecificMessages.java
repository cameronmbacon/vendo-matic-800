package com.techelevator.data;

public enum ItemSpecificMessages {
    CHIP_PURCHASE_MESSAGE("Crunch Crunch, Yum!"),
    CANDY_PURCHASE_MESSAGE("Munch Munch, Yum!"),
    DRINK_PURCHASE_MESSAGE("Glug Glug, Yum!"),
    GUM_PURCHASE_MESSAGE("Chew Chew, Yum!");

    private final String itemMessage;

    ItemSpecificMessages(String itemMessage) {
        this.itemMessage = itemMessage;
    }

    public String getItemMessage() {
        return itemMessage;
    }
}
