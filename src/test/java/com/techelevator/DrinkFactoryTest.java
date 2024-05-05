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

class DrinkFactoryTest {
    private DrinkFactory drinkFactory;
    private DrinkFactory drinkFactoryTwo;
    private ChipFactory chipFactory;
    private Item drinkItemOne;
    private Item drinkItemTwo;
    private Item chipItemOne;
    @BeforeEach
    void setUp() {
        drinkFactory = new DrinkFactory();
        drinkFactoryTwo = new DrinkFactory();
        chipFactory = new ChipFactory();
        drinkItemOne = drinkFactory.createItem("test", "Pepsi", 2.54, Type.DRINK);
        drinkItemTwo = drinkFactoryTwo.createItem("test", "Ginger Ale", 2.89, Type.DRINK);
        chipItemOne = chipFactory.createItem("test", "Doritos", 2.40, Type.CHIP);

    }

    @Test
    void assert_drinkFactory_instanceof_ItemFactory_returns_true() {
        assertTrue(drinkFactory instanceof ItemFactory);
    }

    @Test
    void assert_drinkFactory_new_instance_is_not_null_returns_true() {
        assertTrue(drinkFactory != null);
    }


    @Test
    void assert_drinkFactory_new_instance_matches_correct_class_returns_true() {
        assertTrue(drinkFactory.getClass() == DrinkFactory.class);
    }

    @Test
    void assert_drinkFactory_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(drinkFactory.getClass().equals(ChipFactory.class));
    }

    @Test
    void assert_drinkFactory_instances_of_same_class_returns_true() {
        assertEquals(drinkFactory.getClass(), drinkFactoryTwo.getClass());
    }

    @Test
    void assert_drinkFactory_instances_of_different_classes_are_not_equal() {
        assertNotEquals(drinkFactory.getClass(), chipFactory.getClass());
    }

    @Test
    void assert_factory_instances_of_different_classes_createItem_method_do_not_return_same_type_items() {
        assertNotEquals(drinkItemOne.getProductType(), chipItemOne.getProductType());
    }

    @Test
    void assert_factory_instances_of_same_classes_createItem_method_return_same_type_items() {
        assertEquals(drinkItemOne.getProductType(), drinkItemTwo.getProductType());
    }

    @Test
    void assert_drinkFactory_createItem_returns_correct_item_type() {
        assertTrue(drinkItemOne.getProductType() == Type.DRINK);
    }

    @Test
    void assert_drinkFactory_createItem_returns_false_compared_with_incorrect_item_type() {
        assertFalse(drinkItemOne.getProductType() == Type.CHIP);
    }
}