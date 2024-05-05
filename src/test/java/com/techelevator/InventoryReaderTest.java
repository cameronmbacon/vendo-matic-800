package com.techelevator;

import com.techelevator.constructs.model.*;
import com.techelevator.util.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryReaderTest {

    private InventoryReader inventoryReader;

    @Before
    public void setupForTests() {
        inventoryReader = new InventoryReader();
    }

    @Test
    public void should_not_be_null_after_instantiation() {
        assertNotNull("Should not be null.", inventoryReader);
    }

    @Test
    public void should_read_inventory_file_and_return_items() {
        List<Item> items = new ArrayList<>();
        inventoryReader.readData();

        assertNotNull("Should not be empty.", items);
    }

    @Test
    public void should_parse_line_from_file_and_return_item() {
        Item item = inventoryReader.parseItem("A1|Potato Crisps|3.05|Chip");

        assertNotNull("Parsed item should not be null.", item);
    }
}
