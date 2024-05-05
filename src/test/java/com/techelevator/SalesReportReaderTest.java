package com.techelevator;

import com.techelevator.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalesReportReaderTest {

    private SalesReportReader salesReportReader;

    @Test
    public void assert_SalesReportReader_is_not_null() {
        salesReportReader = new SalesReportReader("sales_reports");

        assertNotNull("salesReportReader should not be null.", salesReportReader);
    }
}
