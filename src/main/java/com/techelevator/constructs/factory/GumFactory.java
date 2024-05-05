package com.techelevator.constructs.factory;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

public class GumFactory implements ItemFactory {
    @Override
    public Item createItem(String slotLocation, String productName, double price, Type productType) {
        return new Item(slotLocation, productName, price, productType);
    }
}
