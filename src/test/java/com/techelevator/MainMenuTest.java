package com.techelevator;

import com.techelevator.constructs.menu.*;
import com.techelevator.constructs.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {
    private MainMenu mainMenu;
    private MainMenuState mainMenuState;
    private MainMenu mainMenuTwo;
    private PurchaseMenu purchaseMenu;
    private String mainMenuTitle = "Main Menu";
    @BeforeEach
    void setUp() {
        mainMenu = new MainMenu();
        mainMenuTwo = new MainMenu();
        purchaseMenu = new PurchaseMenu();
        mainMenuState = new MainMenuState(mainMenu);
    }

    @Test
    void assert_mainMenu_getMenuTitle_returns_correct_name() {
        assertEquals(mainMenuTitle, mainMenu.getMenuTitle());
    }

    @Test
    void assert_mainMenu_getMenuTitle_returns_false_for_incorrect_name() {
        assertFalse(mainMenu.getMenuTitle().equals("Super Menu"));
    }

    @Test
    void assert_mainMenu_instanceof_menu_returns_true() {
        assertTrue(mainMenu instanceof Menu);
    }

    @Test
    void assert_mainMenu_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(mainMenu.getClass().equals(PurchaseMenu.class));
    }

    @Test
    void assert_mainMenu_new_instance_is_not_null_returns_true() {
        assertTrue(mainMenu != null);
    }

    @Test
    void assert_mainMenu_new_instance_matches_correct_class_returns_true() {
        assertTrue(mainMenu.getClass() == MainMenu.class);
    }

    @Test
    void assert_hiddenMenu_instances_of_same_class_returns_true() {
        assertEquals(mainMenu.getClass(), mainMenuTwo.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_are_not_equal() {
        assertNotEquals(mainMenu.getClass(), purchaseMenu.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_have_different_menuTitle_names() {
        assertNotEquals(mainMenu.getMenuTitle(), purchaseMenu.getMenuTitle());
    }

    @Test
    void assert_menu_instances_of_same_classes_have_matching_menuTitle_names() {
        assertEquals(mainMenu.getMenuTitle(), mainMenuTwo.getMenuTitle());
    }
}
