package com.techelevator.constructs.model;

import com.techelevator.constructs.menu.*;
import com.techelevator.constructs.state.*;
import com.techelevator.data.*;
import com.techelevator.util.*;

import java.io.*;
import java.util.*;

public class VendingMachine {
    public VendingMachineHelper helper = new VendingMachineHelper();
    private static volatile VendingMachine instance;
    private Map<String, Item> vendingMachineItems = new HashMap<>();
    private MenuState currentState;
    private SalesReport salesReport;
    private final MachineKeyPad machineKeyPad;

    private double customerMoneyBalance;
    private Map<String, Row> rows;

    private VendingMachine() {
        InventoryReader inventoryReader = new InventoryReader();
        List<Item> stockedItemsFromFile = inventoryReader.readData();
        setVendingMachineItems(helper.convertStockeditemData(stockedItemsFromFile));
        this.rows = buildRows(Row.buildSlots(stockedItemsFromFile));
        this.machineKeyPad = new MachineKeyPad(new InputStreamReader(System.in));
        this.currentState = new MainMenuState(new MainMenu());
        this.salesReport = new SalesReport();
        this.customerMoneyBalance = 0.0;
    }

    public Map<String, Item> getVendingMachineItems() {
        return vendingMachineItems;
    }

    public void setVendingMachineItems(Map<String, Item> vendingMachineItems) {
        this.vendingMachineItems = vendingMachineItems;
    }

    public Map<String, Row> getRows() {
        return rows;
    }

    public MachineKeyPad getMachineKeyPad() {
        return machineKeyPad;
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            synchronized (VendingMachine.class) {
                if (instance == null) {
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }

    public double getCustomerMoneyDepositBalance() {
        return this.customerMoneyBalance;
    }

    public void setCustomerMoneyDepositBalance(double customerMoneyDepositBalance) {
        this.customerMoneyBalance = customerMoneyDepositBalance;
    }

    public void setState(MenuState state) { this.currentState = state;}

    public MenuState getCurrentState() { return this.currentState;}

    public static Map<String, Row> buildRows(List<SlotLocation> slotLocationList) {
        Map<String, Row> builtRows = new HashMap<>();
        List<SlotLocation> listA = new ArrayList<>();
        List<SlotLocation> listB = new ArrayList<>();
        List<SlotLocation> listC = new ArrayList<>();
        List<SlotLocation> listD = new ArrayList<>();

        Row rowA = new Row("A");
        Row rowB = new Row("B");
        Row rowC = new Row("C");
        Row rowD = new Row("D");

        for (SlotLocation slotLocation : slotLocationList) {
            Type productType = slotLocation.getProducts().peekFirst().getProductType();

            switch (productType) {
                case DRINK:
                    listC.add(slotLocation);
                    break;
                case CANDY:
                    listB.add(slotLocation);
                    break;
                case CHIP:
                    listA.add(slotLocation);
                    break;
                case GUM:
                    listD.add(slotLocation);
                    break;
                default:
                    throw new NullPointerException("Unsupported item type: " + productType);
            }
        }

        rowA.setSlots(listA);
        rowB.setSlots(listB);
        rowC.setSlots(listC);
        rowD.setSlots(listD);

        builtRows.put(rowA.getName(), rowA);
        builtRows.put(rowB.getName(), rowB);
        builtRows.put(rowC.getName(), rowC);
        builtRows.put(rowD.getName(), rowD);

        return builtRows;
    }

    public List<SlotLocation> getCurrentInventory() {
        Collection<Row> rows = getRows().values();
        List<SlotLocation> slotLocations = new ArrayList<>();

        for (Row row : rows) {
            slotLocations.addAll(row.getSlots());
        }

        return slotLocations;
    }

    public SalesReport getSalesReport() {
        return salesReport;
    }

    public void displayInventory() {
        List<SlotLocation> inventory = getCurrentInventory();
        String productName = "";
        int quantity = 0;
        double price = 0.0;

        for (SlotLocation slot : inventory) {
            quantity = slot.getQuantity();
            if (quantity > 0) {
                productName = slot.getProducts().peekFirst().getProductName();
                price = slot.getProducts().peekFirst().getPrice();
                DelayGenerator.excecuteHalfSecondDelay();
                System.out.printf("[Slot %s]: %s, $%.2f, Qty: %d\n", slot.getName(), productName, price, quantity);
            } else {
                DelayGenerator.excecuteHalfSecondDelay();
                System.out.printf("[Slot %s]: %s\n", slot.getName(), "SOLD OUT!");
            }
        }
        System.out.println();
        System.out.println();
    }
}
