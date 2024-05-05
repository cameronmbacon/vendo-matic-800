package com.techelevator.constructs.menu;

import com.techelevator.data.*;

public abstract class Menu {

    protected String menuTitle;

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public abstract void displayStartingMenu();

    public String getMenuTitle() {
        return menuTitle;
    }

    public static void displayMenuSelectionPrompt() {
        System.out.print(PromptMessages.MENU_SELECTION_PROMPT.getPromptMessage());
    }
}
