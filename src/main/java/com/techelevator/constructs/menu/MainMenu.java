package com.techelevator.constructs.menu;

import com.techelevator.constructs.model.*;
import com.techelevator.util.*;

import java.util.*;

public class MainMenu extends Menu {
    private Map<Integer, String> selectionOptions = new LinkedHashMap<>();
    private String selectionOptionOne = "Display Vending Machine Items";
    private String selectionOptionTwo = "Purchase";
    private String selectionOptionThree = "Exit";

    public MainMenu() {
        super("Main Menu");
        setupSelectionOptions();
    }

    public void displaySelectionPrompt() {Menu.displayMenuSelectionPrompt();}

    public void displayStockedInventory() {
        VendingMachine.getInstance().displayInventory();
    }

    @Override
    public void displayStartingMenu() {
        System.out.println( "--------------" + this.menuTitle + "--------------");
        System.out.println();

        for (Map.Entry<Integer, String> menuSelection : selectionOptions.entrySet()) {
            Integer menuNumber = menuSelection.getKey();
            String menuOptionValue = menuSelection.getValue();
            DelayGenerator.excecuteOneFourthSecondDelay();
            System.out.println("(" + menuNumber + ") " + menuOptionValue);
        }
        System.out.println();
        System.out.println();
        DelayGenerator.excecuteHalfSecondDelay();
    }


    public void setupSelectionOptions() {
        this.selectionOptions.put(1, selectionOptionOne);
        this.selectionOptions.put(2, selectionOptionTwo);
        this.selectionOptions.put(3, selectionOptionThree);
    }

    public Map<Integer, String> getSelectionOptions() {return selectionOptions; }
}
