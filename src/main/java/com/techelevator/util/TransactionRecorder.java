package com.techelevator.util;

import com.techelevator.constructs.model.Item;
import com.techelevator.constructs.model.VendingMachine;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionRecorder {
    private final String LOG_FILE_NAME = "Log.txt";

    public Item retrieveItemDetails(String customerSelection) {

        VendingMachine vendingMachineInstance = VendingMachine.getInstance();

        return vendingMachineInstance.getVendingMachineItems().get(customerSelection);
    }

    public String recordTransactionTimeStamp() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

    protected void updateCustomerRemainingBalance(Item purchasedItem) {
        double customerMoneyBalance = VendingMachine.getInstance().getCustomerMoneyDepositBalance();
        double purchasedItemCost = purchasedItem.getPrice();
        double formattedBalance = formatPrice((customerMoneyBalance - purchasedItemCost));
        VendingMachine.getInstance().setCustomerMoneyDepositBalance(formattedBalance);
    }

    public double formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(price));
    }

    public String formatPriceToString(double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(price);
    }

    public String logCustomerPurchaseTransactions(String customerSelection) {
        Item purchasedItem = retrieveItemDetails(customerSelection);
        updateCustomerRemainingBalance(retrieveItemDetails(customerSelection));
        writePurchaseTransactionsToFile(recordTransactionTimeStamp(), purchasedItem);
        return generateTransactionLogEntry(purchasedItem);
    }

    public void logCustomerFeedTransactions(double currentTotal, double newTotal) {
        writeFeedTransactionsToFile(recordTransactionTimeStamp(), formatPrice(currentTotal), formatPrice(newTotal));
    }

    public void logChangeTransactions(double changeReturned, double resetBalance) {
        writeChangeTransactionsToFile(recordTransactionTimeStamp(),
                formatPrice(changeReturned), formatPrice(resetBalance));
    }

    private void writeChangeTransactionsToFile(String transactionTimeStamp, double changeReturned, double resetBalance) {
        try {
            BufferedWriter writer = verifyTransactionLogExists();
            writer.write(transactionTimeStamp + " ");
            writer.write("GIVE CHANGE: ");
            writer.write("$" + formatPriceToString(changeReturned));
            writer.write(" $" + formatPriceToString(resetBalance));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to the file.");
        } catch (Exception e) {
            System.out.println("ERROR: Error occurred during transaction logging");
        }
    }

    private void writeFeedTransactionsToFile(String transactionTimeStamp, double currentTotal, double newTotal) {
        try {
            BufferedWriter writer = verifyTransactionLogExists();
            writer.write(transactionTimeStamp + " ");
            writer.write("FEED MONEY: ");
            writer.write("$" + formatPriceToString(currentTotal));
            writer.write(" $" + formatPriceToString(newTotal));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to the file.");
        } catch (Exception e) {
            System.out.println("ERROR: Error occurred during transaction logging");
        }
    }

    private String generateTransactionLogEntry(Item purchasedItem) {
        return String.format("Item: %s\nCost: $%.2f ", purchasedItem.getProductName(), purchasedItem.getPrice());
    }

    public void writePurchaseTransactionsToFile(String transactionTimeStamp, Item purchasedItem) {
        try {
            VendingMachine vendingMachine = VendingMachine.getInstance();
            BufferedWriter writer = verifyTransactionLogExists();
            writer.write(transactionTimeStamp + " ");
            writer.write(purchasedItem.getProductName() + " ");
            writer.write( purchasedItem.getSlotLocation() + " $");
            writer.write(formatPriceToString(purchasedItem.getPrice()) + " $");
            writer.write(formatPriceToString(vendingMachine.getCustomerMoneyDepositBalance()) + " ");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to the file.");
        } catch (Exception e) {
            System.out.println("ERROR: Error occurred during transaction logging");
        }
    }

    public BufferedWriter verifyTransactionLogExists() {
        String currentDir = System.getProperty("user.dir");
        String fullLogFilePath = currentDir + File.separator + LOG_FILE_NAME;

        try {
            File transactionLogFile = new File(fullLogFilePath);
            if(!transactionLogFile.exists()) {
                transactionLogFile.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(transactionLogFile, true));
            return writer;
        } catch(Exception e) {
            System.out.println("ERROR: transaction log malfunction detected. Contact IT Support");
        }
        return null;
    }
}
