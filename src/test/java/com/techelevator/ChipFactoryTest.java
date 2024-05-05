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

class ChipFactoryTest {

    private ChipFactory chipFactory;
    private ChipFactory chipFactoryTwo;
    private DrinkFactory drinkFactory;
    private Item chipItemOne;
    private Item chipItemTwo;
    private Item drinkItemOne;
    @BeforeEach
    void setUp() {
        chipFactory = new ChipFactory();
        chipFactoryTwo = new ChipFactory();
        drinkFactory = new DrinkFactory();
        chipItemOne = chipFactory.createItem("test", "Lays", 2.27, Type.CHIP);
        chipItemTwo = chipFactoryTwo.createItem("test", "Fritos", 3.54, Type.CHIP);
        drinkItemOne = drinkFactory.createItem("test", "Ginger Ale", 2.89, Type.DRINK);

    }

    @Test
    void assert_chipFactory_instanceof_ItemFactory_returns_true() {
        assertTrue(chipFactory instanceof ItemFactory);
    }

    @Test
    void assert_chipFactory_new_instance_is_not_null_returns_true() {
        assertTrue(chipFactory != null);
    }


    @Test
    void assert_chipFactory_new_instance_matches_correct_class_returns_true() {
        assertTrue(chipFactory.getClass() == ChipFactory.class);
    }

    @Test
    void assert_chipFactory_instance_does_not_equal_incorrect_menu_class() {
        assertFalse(chipFactory.getClass().equals(DrinkFactory.class));
    }

    @Test
    void assert_chipFactory_instances_of_same_class_returns_true() {
        assertEquals(chipFactory.getClass(), chipFactoryTwo.getClass());
    }

    @Test
    void assert_chipFactory_instances_of_different_classes_are_not_equal() {
        assertNotEquals(chipFactory.getClass(), drinkFactory.getClass());
    }

    @Test
    void assert_factory_instances_of_different_classes_createItem_method_do_not_return_same_type_items() {
        assertNotEquals(chipItemOne.getProductType(), drinkItemOne.getProductType());
    }

    @Test
    void assert_factory_instances_of_same_classes_createItem_method_return_same_type_items() {
        assertEquals(chipItemOne.getProductType(), chipItemTwo.getProductType());
    }

    @Test
    void assert_chipFactory_createItem_returns_correct_item_type() {
        assertTrue(chipItemOne.getProductType() == Type.CHIP);
    }

    @Test
    void assert_chipFactory_createItem_returns_false_compared_with_incorrect_item_type() {
        assertFalse(chipItemOne.getProductType() == Type.DRINK);
    }
}