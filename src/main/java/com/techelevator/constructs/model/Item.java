package com.techelevator.constructs.model;

import com.techelevator.data.*;

public class Item {
    private String slotLocation;
    private String productName;
    private double price;
    private Type productType;
    public Item(String slotLocation, String productName, double price, Type productType) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Type getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "slotLocation: " + getSlotLocation() +
                "\nproductName: " + getProductName() +
                "\nprice: $" + getPrice() +
                "\nproductType: " + getProductType().getProductType() + "\n";
    }
}
