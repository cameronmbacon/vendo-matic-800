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

class GumFactoryTest {
    private GumFactory gumFactory;
    private GumFactory gumFactoryTwo;
    private DrinkFactory drinkFactory;
    private Item gumItemOne;
    private Item gumItemTwo;
    private Item drinkItemOne;
    @BeforeEach
    void setUp() {
        gumFactory = new GumFactory();
        gumFactoryTwo = new GumFactory();
        drinkFactory = new DrinkFactory();
        gumItemOne = gumFactory.createItem("test", "Mentos", 1.50, Type.GUM);
        gumItemTwo = gumFactoryTwo.createItem("test", "Juicy Fruit", 1.20, Type.GUM);
        drinkItemOne = drinkFactory.createItem("test", "Coke", 3.45, Type.DRINK);

    }

    @Test
    void assert_gumFactory_instanceof_ItemFactory_returns_true() {
        assertTrue(gumFactory instanceof ItemFactory);
    }

    @Test
    void assert_gumFactory_new_instance_is_not_null_returns_true() {
        assertTrue(gumFactory != null);
    }


    @Test
    void assert_gumFactory_new_instance_matches_correct_class_returns_true() {
        assertTrue(gumFactory.getClass() == GumFactory.class);
    }

    @Test
    void assert_gumFactory_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(gumFactory.getClass().equals(DrinkFactory.class));
    }

    @Test
    void assert_gumFactory_instances_of_same_class_returns_true() {
        assertEquals(gumFactory.getClass(), gumFactoryTwo.getClass());
    }

    @Test
    void assert_gumFactory_instances_of_different_classes_are_not_equal() {
        assertNotEquals(gumFactory.getClass(), drinkFactory.getClass());
    }

    @Test
    void assert_factory_instances_of_different_classes_createItem_method_do_not_return_same_type_items() {
        assertNotEquals(gumItemOne.getProductType(), drinkItemOne.getProductType());
    }

    @Test
    void assert_factory_instances_of_same_classes_createItem_method_return_same_type_items() {
        assertEquals(gumItemOne.getProductType(), gumItemTwo.getProductType());
    }

    @Test
    void assert_gumFactory_createItem_returns_correct_item_type() {
        assertTrue(gumItemOne.getProductType() == Type.GUM);
    }

    @Test
    void assert_gumFactory_createItem_returns_false_compared_with_incorrect_item_type() {
        assertFalse(gumItemOne.getProductType() == Type.DRINK);
    }
}