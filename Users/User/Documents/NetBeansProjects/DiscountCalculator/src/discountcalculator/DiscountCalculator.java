/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package discountcalculator;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author User
 */
public class DiscountCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Call this method to read an input file.
        readInputFile();
    }

    // This method is used to read the data from an input file and convert in into a Customer object.
    private static void readInputFile() {
        // Declared path to an input file in the following variable.
        // Makes it easier to change it later.
        String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\DiscountCalculator\\src\\discountcalculator\\customers.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String userName;

            // Use while block to read the data from the file until we reach an end of the file
            while ((userName = bufferedReader.readLine()) != null) {
                String baseValueString = bufferedReader.readLine();
                String customerClassString = bufferedReader.readLine();
                String lastPurchaseYearString = bufferedReader.readLine();

                // The following block converts string variables into a data
                // that can be assigned to properties of Customer object.
                // Use try/catch block here to perform validation checks.
                // 
                // TODO: Implement validations.
                try {
                    double baseValue = Double.parseDouble(baseValueString);
                    int customerClass = Integer.parseInt(customerClassString);
                    int lastPurchaseYear = Integer.parseInt(lastPurchaseYearString);
                    
                    // Create a new customer with the data read from the input file.
                    Customer customer = new Customer(userName, baseValue, customerClass, lastPurchaseYear);
                
                    writeOutputFile(customer);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
    /**
     * @param Customer object
     */
    // Method used to create and populate output file with customer name and final purchase values.
    private static void writeOutputFile(Customer customer) {
        // Declared path to an output file in the following variable.
        String outputFilePath = "TODO: Enter here";
        
        System.out.println(customer.getName());
        System.out.println(customer.getBaseValue());
        System.out.println(customer.getFinalValue());
    }
}
