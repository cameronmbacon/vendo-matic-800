package com.techelevator.util;

import com.techelevator.constructs.factory.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryReader implements DataReader<List<Item>> {

    private final static String INVENTORY_FILE_PATH = "./vendingmachine.csv";
    private final static File inventoryFile = new File(INVENTORY_FILE_PATH);

    private CandyFactory candyFactory = new CandyFactory();
    private DrinkFactory drinkFactory = new DrinkFactory();
    private ChipFactory chipFactory = new ChipFactory();
    private GumFactory gumFactory = new GumFactory();

    @Override
    public List<Item> readData() {
        List<Item> items = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inventoryFile))) {
            Item item = null;
            while (bufferedReader.ready()) {
                item = parseItem(bufferedReader.readLine());
                items.add(item);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return items;
    }

    public Item parseItem(String line) {
        List<String> lineItemProperties = Arrays.asList(line.split("\\|"));
        String slotLocation = lineItemProperties.get(0);
        String productName = lineItemProperties.get(1);
        double price = Double.parseDouble(lineItemProperties.get(2));
        Type productType = Type.fromString(lineItemProperties.get(3));
        Item item = null;

        switch (productType) {
            case DRINK:
                item = drinkFactory.createItem(slotLocation, productName, price, productType);
                break;
            case CANDY:
                item = candyFactory.createItem(slotLocation, productName, price, productType);
                break;
            case CHIP:
                item = chipFactory.createItem(slotLocation, productName, price, productType);
                break;
            case GUM:
                item = gumFactory.createItem(slotLocation, productName, price, productType);
                break;
            default:
                throw new IllegalArgumentException("Unsupported item type: " + productType);
        }

        return item;
    }
}
