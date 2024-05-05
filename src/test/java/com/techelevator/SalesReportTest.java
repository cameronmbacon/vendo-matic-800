package com.techelevator;

import com.techelevator.constructs.model.*;
import com.techelevator.data.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class SalesReportTest {

    private SalesReport salesReport;
    private Item drink;

    @Before
    public void setUp() {
        salesReport = new SalesReport();
        drink = new Item("A5", "Rockstar", 3.0, Type.DRINK);
        Item candy = new Item("B3", "Trolli's Sour Worms", 1.5, Type.CANDY);
        salesReport.addSale(drink.getProductName(), drink.getPrice());
        salesReport.addSale(candy.getProductName(), candy.getPrice());
    }

    @Test
    public void salesReport_should_not_be_null_after_instantiating() {
        assertNotNull("Should not be null.", salesReport);
    }

    @Test
    public void initial_total_sales_should_be_zero() {
        SalesReport emptySalesReport = new SalesReport();
        assertEquals(0.0, emptySalesReport.getTotalSales(), 0.0);
    }

    @Test
    public void addSale_should_update_total_sales_with_correct_amount() {
        assertEquals(4.5, salesReport.getTotalSales(), 0.0);
    }

    @Test
    public void addSale_should_add_sale_to_sales_Map() {
        Map<String, Integer> sales = salesReport.getSales();
        assertTrue("quantitySold should be an instance of Integer", sales.get(drink.getProductName()) instanceof Integer);
        assertFalse("sales Map should contain a transaction.", sales.isEmpty());
    }

    @Test
    public void generateReport_should_product_correct_format() {
        String expectedOutput = "Trolli's Sour Worms|1\nRockstar|1\n\n**TOTAL SALES** $4.5";
        assertEquals("Generated sales report format should match expected output", expectedOutput, salesReport.generateSalesReportData());
    }
}
