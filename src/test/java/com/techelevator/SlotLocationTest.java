package com.techelevator;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlotLocationTest {

    SlotLocation slotLocation;

    @Before
    public void createNewInstanceOfSlotLocation() {
        slotLocation = new SlotLocation("A1");
        Item itemOne = new Item("A1", "Rockstar", 3.0, Type.DRINK);
        Item itemTwo = new Item("B1", "Trolli's Sour Worms", 1.5, Type.CANDY);
        slotLocation.addItem(itemOne);
        slotLocation.addItem(itemTwo);
    }

    @Test
    public void should_be_instance_of_SlotLocation_and_not_null() {
        assertNotNull("Local variable 'slotLocation' should not be null.", slotLocation);
    }

    @Test
    public void constructor_should_assign_name_and_products() {
        assertEquals("Name should match argument passed to constructor.", "A1", slotLocation.getName());
        assertNotNull("Products should match argument passed to constructor.", slotLocation.getProducts());
    }

    @Test
    public void initial_quantity_should_equal_size_of_products() {
        assertEquals("Initial quantity should equal size of products List.", slotLocation.getProducts().size(), slotLocation.getQuantity());
    }

    @Test
    public void should_add_item_to_slot_if_quantity_less_than_five() {
        Item item = new Item("A2", "Red Bull", 3.5, Type.DRINK);
        slotLocation.addItem(item);

        assertTrue("List of products should contain an item.", slotLocation.getProducts().contains(item));
    }

    @Test
    public void vendItem_should_only_vend_one_item() {
        assertNotNull("One item should have been vended from products.", slotLocation.vendItem());
    }

    @Test
    public void should_load_slot_location_with_five_items() {
        SlotLocation b5 = new SlotLocation("B5");
        Item item = new Item("B5", "Reese's Peanut Butter Cups", 1.5, Type.CANDY);
        b5.load(item);

        assertEquals("Slot location should have 5 items stocked.", 5, b5.getQuantity());
    }
}
