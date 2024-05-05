package com.techelevator;

import com.techelevator.constructs.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseMenuTest {

    private PurchaseMenu purchaseMenu;
    private PurchaseMenu purchaseMenuTwo;
    private HiddenMenu hiddenMenu;
    private String purchaseMenuTitle = "Purchase Menu";
    @BeforeEach
    void setUp() {

        purchaseMenu = new PurchaseMenu();
        purchaseMenuTwo = new PurchaseMenu();
        hiddenMenu = new HiddenMenu();
    }

    @Test
    void assert_purchaseMenu_getSelectionOptions_method_returns_size_three() {
        assertEquals(3, purchaseMenu.getSelectionOptions().size());
    }

    @Test
    void assert_hiddenMenu_getSelectionOptions_method_check_only_matches_correct_size() {
        assertNotEquals(6, purchaseMenu.getSelectionOptions().size());
    }

    @Test
    void assert_purchaseMenu_getMenuTitle_returns_correct_name() {
        assertEquals(purchaseMenuTitle, purchaseMenu.getMenuTitle());
    }

    @Test
    void assert_hiddenMenu_getMenuTitle_returns_false_for_incorrect_name() {
        assertFalse(purchaseMenu.getMenuTitle().equals("Mega Menu"));
    }

    @Test
    void assert_purchaseMenu_instanceof_menu_returns_true() {
        assertTrue(purchaseMenu instanceof Menu);
    }

    @Test
    void assert_purchaseMenu_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(purchaseMenu.getClass().equals(HiddenMenu.class));
    }

    @Test
    void assert_purchaseMenu_new_instance_is_not_null_returns_true() {
        assertTrue(purchaseMenu != null);
    }

    @Test
    void assert_purchaseMenu_new_instance_matches_correct_class_returns_true() {
        assertTrue(purchaseMenu.getClass() == PurchaseMenu.class);
    }
    @Test
    void assert_purchaseMenu_instances_of_same_class_returns_true() {
        assertEquals(purchaseMenu.getClass(), purchaseMenuTwo.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_are_not_equal() {
        assertNotEquals(hiddenMenu.getClass(), purchaseMenu.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_have_different_menuTitle_names() {
        assertNotEquals(purchaseMenu.getMenuTitle(), hiddenMenu.getMenuTitle());
    }

    @Test
    void assert_menu_instances_of_same_classes_have_matching_menuTitle_names() {
        assertEquals(purchaseMenu.getMenuTitle(), purchaseMenuTwo.getMenuTitle());
    }
}