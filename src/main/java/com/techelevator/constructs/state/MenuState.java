package com.techelevator.constructs.state;

public interface MenuState {

    void displayMenu();

    void handleCustomerInput(String customerInput);

    void displayMenuStartingPrompt();
}
