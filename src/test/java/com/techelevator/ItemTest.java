package com.techelevator;

import com.techelevator.constructs.factory.*;
import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

class ItemTest {
    private Item testCandyItemOne;
    private Item testCandyItemTwo;
    private Item testGumItemOne;
    private double test_price = 99.99;
    @BeforeEach
    void setUp() {
        testCandyItemOne = new Item("test", "testCandyItemOne", test_price, Type.CANDY);
        testCandyItemTwo = new Item("test", "testCandyItemTwo", test_price, Type.CANDY);
        testGumItemOne = new Item("test", "testGumItemOne", test_price, Type.GUM);
    }

    @Test
    void assert_item_getSlotLocation_method_returns_true_with_correct_slotLocation_passed() {
        assertEquals("test", testCandyItemOne.getSlotLocation());
    }

    @Test
    void assert_item_getProductName_method_returns_true_compared_with_correct_name() {
        assertEquals("testCandyItemOne", testCandyItemOne.getProductName());
    }

    @Test
    void assert_item_getPrice_method_returns_true_with_correct_price_passed() {
        assertEquals(test_price, testCandyItemOne.getPrice().doubleValue(), 0.01);
    }

    @Test
    void assert_item_getProductType_method_returns_true_with_correct_type_match() {
        assertEquals(Type.CANDY, testCandyItemOne.getProductType());
    }

    @Test
    void assert_item_returns_false_compared_with_incorrect_item_type() {
        assertFalse(testCandyItemOne.getProductType() == Type.DRINK);
    }

    @Test
    void assert_item_new_instance_matches_correct_class_returns_true() {
        assertTrue(testCandyItemOne.getClass() == Item.class);
    }

    @Test
    void assert_item_instance_does_not_equal_incorrect_class() {
        assertFalse(testCandyItemOne.getClass().equals(DrinkFactory.class));
    }

    @Test
    void assert_item_instances_of_same_class_returns_true() {
        assertEquals(testCandyItemOne.getClass(), testCandyItemTwo.getClass());
    }

    @Test
    void assert_item_instances_of_different_classes_do_not_return_same_type_items() {
        assertNotEquals(testGumItemOne.getProductType(), testCandyItemTwo.getProductType());
    }

    @Test
    void assert_item_instances_of_same_classes_return_same_type_items() {
        assertEquals(testCandyItemOne.getProductType(), testCandyItemTwo.getProductType());
    }
}