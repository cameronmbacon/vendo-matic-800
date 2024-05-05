package com.techelevator.constructs.state;

import com.techelevator.constructs.menu.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import com.techelevator.util.*;

public class HiddenMenuState implements MenuState {

    private HiddenMenu hiddenMenu;
    private SalesReport salesReport = VendingMachine.getInstance().getSalesReport();

    public HiddenMenuState(HiddenMenu hiddenMenu) {
        this.hiddenMenu = hiddenMenu;
    }

    public void displayMenu() {
        hiddenMenu.displayStartingMenu();
    }

    public void displayMenuStartingPrompt() {
        this.hiddenMenu.displaySelectionPrompt();
    }

    public void handleCustomerInput(String customerInput) {
        if(customerInput.equals("1")) {
            System.out.println(GeneralMessages.SALES_REPORT_LOADING_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            System.out.println(salesReport.generateSalesReportData());
            DelayGenerator.excecuteThreeSecondDelay();

        }
        if(customerInput.equals("2")) {
            System.out.println(GeneralMessages.GENERATE_SALES_REPORT_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            salesReport.generateSalesReportFile();
            DelayGenerator.excecuteTwoSecondDelay();
        }
        if(customerInput.equals("3")) {
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteThreeSecondDelay();
            VendingMachine.getInstance().setState(new MainMenuState(new MainMenu()));
            System.out.println( GeneralMessages.MAIN_MENU_LOADING_MESSAGE.getGeneralMessage());
            DisplayUtils.displayMenuFormatPrints();
            DelayGenerator.excecuteFourSecondDelay();
        }
        if(customerInput.equals("4")) {
            System.err.println(GeneralMessages.ALREADY_IN_HIDDEN_MENU_ERROR.getGeneralMessage());
            DisplayUtils.displayLineFormatPrints();
            DelayGenerator.excecuteTwoSecondDelay();
        }
    }
}
