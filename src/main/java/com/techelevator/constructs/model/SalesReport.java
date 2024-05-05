package com.techelevator.constructs.model;

import com.techelevator.util.*;

import java.nio.file.FileSystems;
import java.util.Map;

public class SalesReport {

    private final static String TOTAL_SALES_LABEL = "\n**TOTAL SALES** $";
    private final static String DELIMITER = "|";
    private final static String NEWLINE = "\n";
    private final static String PATH_TO_SALES_REPORTS_DIRECTORY = "sales_reports";
    private final static int INITIAL_QUANTITY_SOLD = 1;
    private final static double INITIAL_TOTAL_SALES = 0.0;

    private double totalSales;
    private Map<String, Integer> sales;
    private SalesReportReader salesReportReader;
    private SalesReportWriter salesReportWriter;

    public SalesReport() {
        this.totalSales = INITIAL_TOTAL_SALES;
        this.salesReportReader = new SalesReportReader(PATH_TO_SALES_REPORTS_DIRECTORY);
        this.salesReportWriter = new SalesReportWriter();
        this.sales = salesReportReader.readData();
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public void addSale(String productName, Double price) throws UnsupportedOperationException {
        double totalSales = getTotalSales();
        totalSales += price;

        setTotalSales(totalSales);

        if (getSales().get(productName) == null) {
            sales.put(productName, INITIAL_QUANTITY_SOLD);
        } else {
            Integer quantitySold = getSales().get(productName);
            getSales().replace(productName, ++quantitySold);
        }
    }

    public Map<String, Integer> getSales() {
        return sales;
    }

    public String generateSalesReportData() {
        StringBuilder stringifiedReport = new StringBuilder();

        for (Map.Entry<String, Integer> sale : sales.entrySet()) {
            stringifiedReport.append(sale.getKey()).append(DELIMITER).append(sale.getValue()).append(NEWLINE);
        }

        stringifiedReport.append(TOTAL_SALES_LABEL).append(getTotalSales());
        
        return stringifiedReport.toString();
    }

    public void generateSalesReportFile() {
        String report = generateSalesReportData();
        salesReportWriter.writeToFile(report, PATH_TO_SALES_REPORTS_DIRECTORY);
    }
}
