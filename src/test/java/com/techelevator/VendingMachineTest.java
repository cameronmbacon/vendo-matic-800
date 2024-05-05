package com.techelevator;

import com.techelevator.constructs.model.*;
import com.techelevator.util.*;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

    @Test
    public void constructor_access_modifier_should_be_private() throws Exception {
        Constructor<VendingMachine> constructor = VendingMachine.class.getDeclaredConstructor();

        assertTrue("Constructor access modifier should be private.", Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    public void getInstance_should_return_same_instance() {
        VendingMachine vm1 = VendingMachine.getInstance();
        VendingMachine vm2 = VendingMachine.getInstance();

        assertSame("Instances should be the same.", vm1, vm2);
    }

    @Test
    public void buildRows_should_return_a_map_of_rows() {
        InventoryReader inventoryReader = new InventoryReader();
        List<SlotLocation> slotLocations = Row.buildSlots(inventoryReader.readData());
        Map<String, Row> rows = VendingMachine.buildRows(slotLocations);
        assertNotNull("Rows should not be null.", rows);
    }

    @Test
    public void newly_instantiated_vending_machine_should_be_full() {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        assertFalse("Rows should all be fully stocked.", vendingMachine.getRows().isEmpty());
    }

    @Test
    public void should_return_current_vending_machine_inventory() {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        assertFalse("Current inventory list should not be empty.", vendingMachine.getCurrentInventory().isEmpty());
    }

    @Test
    public void should_print_items_if_quantity_greater_than_zero() {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        vendingMachine.displayInventory();

        assertEquals("Should print current inventory.",
                "[Slot A1]: Potato Crisps, $3.05, Qty: 5\n" +
                "[Slot A2]: Stackers, $1.45, Qty: 5\n" +
                "[Slot A3]: Grain Waves, $2.75, Qty: 5\n" +
                "[Slot A4]: Cloud Popcorn, $3.65, Qty: 5\n" +
                "[Slot B1]: Moonpie, $1.80, Qty: 5\n" +
                "[Slot B2]: Cowtales, $1.50, Qty: 5\n" +
                "[Slot B3]: Wonka Bar, $1.50, Qty: 5\n" +
                "[Slot B4]: Crunchie, $1.75, Qty: 5\n" +
                "[Slot C1]: Cola, $1.25, Qty: 5\n" +
                "[Slot C2]: Dr. Salt, $1.50, Qty: 5\n" +
                "[Slot C3]: Mountain Melter, $1.50, Qty: 5\n" +
                "[Slot C4]: Heavy, $1.50, Qty: 5\n" +
                "[Slot D1]: U-Chews, $0.85, Qty: 5\n" +
                "[Slot D2]: Little League Chew, $0.95, Qty: 5\n" +
                "[Slot D3]: Chiclets, $0.75, Qty: 5\n" +
                "[Slot D4]: Triplemint, $0.75, Qty: 5\n", outputStream.toString());
    }
}