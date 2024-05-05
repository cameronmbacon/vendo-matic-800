package com.techelevator;

import com.techelevator.constructs.model.*;
import com.techelevator.util.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RowTest {

    private Row row;

    @Before
    public void createInstanceOfRowClass() {
        row = new Row("A");
    }

    @Test
    public void should_be_instance_of_Row_and_not_null() {
        assertNotNull("Local variable 'row' should not be null.", row);
    }

    @Test
    public void row_constructor_should_assign_name_property() {
        assertEquals("Row should have same name as constructor argument", "A", row.getName());
    }

    @Test
    public void should_return_a_List_of_slot_locations() {
        InventoryReader inventoryReader = new InventoryReader();
        List<SlotLocation> slotLocations = Row.buildSlots(inventoryReader.readData());

        assertNotNull("List should contain slot locations.", slotLocations);
    }
}
