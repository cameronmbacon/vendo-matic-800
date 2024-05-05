package com.techelevator.constructs.model;

import com.techelevator.constructs.model.*;
import com.techelevator.util.*;

public class VendingMachineSoftwareApp {
	private VendingMachine vendingMachine = VendingMachine.getInstance();
	private CustomerInputValidator customerInputValidator = new CustomerInputValidator();

	public void initialize() {
		conductCurrentMenuProcess();
	}

	private void conductCurrentMenuProcess() {
		boolean inputIsValid = false;

		while(!inputIsValid) {
			vendingMachine.getCurrentState().displayMenu();
			vendingMachine.getInstance().getCurrentState().displayMenuStartingPrompt();
			String customerMenuSelection = vendingMachine.getMachineKeyPad().getCustomerInput();
			inputIsValid = customerInputValidator.validateCustomerSelection(customerMenuSelection);
			if(inputIsValid) {
				vendingMachine.getCurrentState().handleCustomerInput(customerMenuSelection);
				conductCurrentMenuProcess();
			}
		}
	}
}
