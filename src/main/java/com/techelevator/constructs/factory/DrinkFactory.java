package com.techelevator.constructs.factory;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

public class DrinkFactory implements ItemFactory {

    public Item createItem(String slotLocation, String productName, double price, Type productType) {
        return new Item(slotLocation, productName, price, productType);
    }
}
