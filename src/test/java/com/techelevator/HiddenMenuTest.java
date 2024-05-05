package com.techelevator;

import com.techelevator.constructs.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HiddenMenuTest {
    private HiddenMenu hiddenMenu;
    private PurchaseMenu purchaseMenu;
    private HiddenMenu hiddenMenuTwo;
    private String hiddenMenuTitle = "Hidden Menu";
    @BeforeEach
    void setUp() {
        hiddenMenu = new HiddenMenu();
        purchaseMenu = new PurchaseMenu();
        hiddenMenuTwo = new HiddenMenu();
    }

    @Test
    void assert_hiddenMenu_getSelectionOptions_method_returns_size_three() {
        assertEquals(3, hiddenMenu.getSelectionOptions().size());
    }

    @Test
    void assert_hiddenMenu_getSelectionOptions_method_check_only_matches_correct_size() {
        assertNotEquals(4, hiddenMenu.getSelectionOptions().size());
    }

    @Test
    void assert_hiddenMenu_getMenuTitle_returns_correct_name() {
        assertEquals(hiddenMenuTitle, hiddenMenu.getMenuTitle());
    }

    @Test
    void assert_hiddenMenu_getMenuTitle_returns_false_for_incorrect_name() {
        assertFalse(hiddenMenu.getMenuTitle().equals("Ultra Menu"));
    }

    @Test
    void assert_hiddenMenu_instanceof_menu_returns_true() {
        assertTrue(hiddenMenu instanceof Menu);
    }

    @Test
    void assert_hiddenMenu_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(hiddenMenu.getClass().equals(PurchaseMenu.class));
    }

    @Test
    void assert_hiddenMenu_new_instance_is_not_null_returns_true() {
        assertTrue(hiddenMenu != null);
    }

    @Test
    void assert_hiddenMenu_new_instance_matches_correct_class_returns_true() {
        assertTrue(hiddenMenu.getClass() == HiddenMenu.class);
    }

    @Test
    void assert_hiddenMenu_instances_of_same_class_returns_true() {
        assertEquals(hiddenMenu.getClass(), hiddenMenuTwo.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_are_not_equal() {
        assertNotEquals(hiddenMenu.getClass(), purchaseMenu.getClass());
    }

    @Test
    void assert_menu_instances_of_different_classes_have_different_menuTitle_names() {
        assertNotEquals(hiddenMenu.getMenuTitle(), purchaseMenu.getMenuTitle());
    }

    @Test
    void assert_menu_instances_of_same_classes_have_matching_menuTitle_names() {
        assertEquals(hiddenMenu.getMenuTitle(), hiddenMenuTwo.getMenuTitle());
    }
}