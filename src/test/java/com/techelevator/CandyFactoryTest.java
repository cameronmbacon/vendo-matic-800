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

class CandyFactoryTest {
private CandyFactory candyFactory;
    private CandyFactory candyFactoryTwo;
    private DrinkFactory drinkFactory;
    private Item candyItemOne;
    private Item candyItemTwo;
    private Item drinkItemOne;
    @BeforeEach
    void setUp() {
        candyFactory = new CandyFactory();
        candyFactoryTwo = new CandyFactory();
        drinkFactory = new DrinkFactory();
        candyItemOne = candyFactory.createItem("test", "Skittles", 2.00, Type.CANDY);
        candyItemTwo = candyFactoryTwo.createItem("test", "Gushers", 3.30, Type.CANDY);
        drinkItemOne = drinkFactory.createItem("test", "Ginger Ale", 2.89, Type.DRINK);

    }

    @Test
    void assert_candyFactory_instanceof_ItemFactory_returns_true() {
        assertTrue(candyFactory instanceof ItemFactory);
    }

    @Test
    void assert_candyFactory_new_instance_is_not_null_returns_true() {
        assertTrue(candyFactory != null);
    }


    @Test
    void assert_candyFactory_new_instance_matches_correct_class_returns_true() {
        assertTrue(candyFactory.getClass() == CandyFactory.class);
    }

    @Test
    void assert_candyFactory_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(candyFactory.getClass().equals(DrinkFactory.class));
    }

    @Test
    void assert_candyFactory_instances_of_same_class_returns_true() {
        assertEquals(candyFactory.getClass(), candyFactoryTwo.getClass());
    }

    @Test
    void assert_candyFactory_instances_of_different_classes_are_not_equal() {
        assertNotEquals(candyFactory.getClass(), drinkFactory.getClass());
    }

    @Test
    void assert_factory_instances_of_different_classes_createItem_method_do_not_return_same_type_items() {
        assertNotEquals(candyItemOne.getProductType(), drinkItemOne.getProductType());
    }

    @Test
    void assert_factory_instances_of_same_classes_createItem_method_return_same_type_items() {
        assertEquals(candyItemOne.getProductType(), candyItemTwo.getProductType());
    }

    @Test
    void assert_candyFactory_createItem_returns_correct_item_type() {
        assertTrue(candyItemOne.getProductType() == Type.CANDY);
    }

    @Test
    void assert_candyFactory_createItem_returns_false_compared_with_incorrect_item_type() {
        assertFalse(candyItemOne.getProductType() == Type.DRINK);
    }
}