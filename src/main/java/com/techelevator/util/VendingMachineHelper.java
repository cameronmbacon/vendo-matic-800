package com.techelevator.util;


import com.techelevator.constructs.factory.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

import java.util.*;

public class VendingMachineHelper {

    private final int ITEM_STOCK_SIZE_LIMIT = 5;
    public void executeStockingVendingMachineItem(String slotLocation, String productName,
                                                  double price, Type productType,
                                                  Map<Item, Integer> vendingMachineItems) {
        ItemFactory itemFactory = provideCorrectItemFactory(productType);
        Item itemToAdd = itemFactory.createItem(slotLocation, productName, price, productType);

        if(!vendingMachineItems.containsKey(itemToAdd)) {
            vendingMachineItems.put(itemToAdd, ITEM_STOCK_SIZE_LIMIT);
            System.out.println(itemToAdd.getProductName() + " remaining quantity:  " + ITEM_STOCK_SIZE_LIMIT);
        } else {
            System.out.println(itemToAdd.getProductName() + " has already been stocked in vending machine");
        }
    }

    private ItemFactory provideCorrectItemFactory(Type productType) {
        if (productType.getProductType().toLowerCase().equals("chip")) {
            return new ChipFactory();
        }
        if (productType.getProductType().toLowerCase().equals("candy")) {
            return new CandyFactory();
        }
        if (productType.getProductType().toLowerCase().equals("drink")) {
            return new DrinkFactory();
        }
        if (productType.getProductType().toLowerCase().equals("gum")) {
            return new GumFactory();
        }
        return null;
    }

    public void sendCustomerSelectionPrompt() {
        System.out.println();
        VendingMachine.getInstance().getCurrentState().displayMenuStartingPrompt();
        System.out.println();
    }


    public void removeVendingMachineItem(Item itemToRemove, Map<Item, Integer> vendingMachineItems) {
        if(vendingMachineItems.containsKey(itemToRemove)) {
            int itemCurrentCount = vendingMachineItems.get(itemToRemove);
            vendingMachineItems.put(itemToRemove, itemCurrentCount - 1);
            System.out.println(itemToRemove.getProductName() + " remaining quantity:  " + (itemCurrentCount - 1));
        } else {
            System.out.println(itemToRemove.getProductName() + " not found in vending machine");
        }
    }

    public Map<String, Item> convertStockeditemData(List<Item> itemList) {
        Map<String, Item> itemMap = new HashMap<>();
        for (Item item : itemList) {
            String slotLocation = item.getSlotLocation();
            itemMap.put(slotLocation, item);
        }
        return itemMap;
    }
}
