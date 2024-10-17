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
        // Declared paths to input and output files in the following variables.
        // Makes it easier to change them later.
        String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\DiscountCalculator\\src\\discountcalculator\\customers.txt";
        String outputFilePath = "TODO: Enter here";

        // This block of code reads the data from an input file
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
                
                    System.out.println(customer.getName());
                    System.out.println(customer.getBaseValue());
                    System.out.println(customer.getFinalValue());
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    
}
