package com.techelevator.constructs.model;

import com.techelevator.constructs.model.*;

import java.util.Deque;
import java.util.LinkedList;

public class SlotLocation {

    private final static int MAX_ITEMS_PER_SLOT = 5;

    private Deque<Item> products;
    private String name;
    private int quantity;

    public SlotLocation(String name) {
        this.name = name;
        this.products = new LinkedList<>();
        this.quantity = 0;
    }

    public Deque<Item> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addItem(Item item) {
        if (getQuantity() < MAX_ITEMS_PER_SLOT) {
            getProducts().addFirst(item);
            setQuantity(getQuantity() + 1);
        }
    }

    public void load(Item item) {
        while (getQuantity() < MAX_ITEMS_PER_SLOT) {
            addItem(item);
        }
    }

    public Item vendItem() {
        Item item = null;

        if (getQuantity() > 0) {
            item = getProducts().removeFirst();
            setQuantity(getQuantity() - 1);
        }

        return item;
    }

    @Override
    public String toString() {
        return "SlotLocation{" +
                "products=" + products +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
