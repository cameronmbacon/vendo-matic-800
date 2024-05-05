package com.techelevator.constructs.state;

import com.techelevator.constructs.menu.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import com.techelevator.util.*;

public class MainMenuState implements MenuState {
    private MainMenu mainMenu;
    private CustomerInputValidator customerInputValidator = new CustomerInputValidator();

    public MainMenuState(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void displayMenu() {
        this.mainMenu.displayStartingMenu();
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    @Override
    public void handleCustomerInput(String customerInput) {
        if(customerInput.equals("1")) {
            System.out.println(GeneralMessages.DISPLAYING_ITEMS_MESSAGE.getGeneralMessage());
            System.out.println();
            DelayGenerator.excecuteThreeSecondDelay();
            getMainMenu().displayStockedInventory();
        }
        if(customerInput.equals("2")) {
            System.out.println();
            VendingMachine.getInstance().setState(new PurchaseMenuState(new PurchaseMenu()));
            System.out.println(GeneralMessages.PURCHASE_MENU_LOADING_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteFourSecondDelay();
        }

        if(customerInput.equals("3")) {
            System.out.println( GeneralMessages.EXIT_VENDING_MACHINE_MESSAGE.getGeneralMessage());
            System.exit(0);
        }
        if(customerInput.equals("4")) {
            if(customerInputValidator.validateSecretPasswordIsPassed()) {
                System.out.println();
                VendingMachine.getInstance().setState(new HiddenMenuState(new HiddenMenu()));
                System.out.println(GeneralMessages.HIDDEN_MENU_LOADING_MESSAGE.getGeneralMessage());
                DisplayUtils.displayMenuFormatPrints();
                DelayGenerator.excecuteFourSecondDelay();
            }
        }
    }

    public void displayMenuStartingPrompt() {
        this.mainMenu.displaySelectionPrompt();
    }
}
