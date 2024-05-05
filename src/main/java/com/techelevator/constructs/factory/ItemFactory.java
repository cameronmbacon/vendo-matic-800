package com.techelevator.constructs.factory;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

public interface ItemFactory {
    Item createItem(String slotLocation, String productName, double price, Type productType);
}
