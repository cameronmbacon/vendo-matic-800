package com.techelevator;

import com.techelevator.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalesReportWriterTest {

    @Test
    public void assert_instance_of_report_writer_is_not_null() {
        SalesReportWriter salesReportWriter = new SalesReportWriter();

        assertNotNull("Instance of ReportWriter should not be null", salesReportWriter);
    }
}
