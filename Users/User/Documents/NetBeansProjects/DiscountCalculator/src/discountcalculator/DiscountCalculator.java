package discountcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DiscountCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Link to GitHub repo:
         *
         * https://github.com/Iverick/Discount-Calculator/tree/master/Users/User/Documents/NetBeansProjects/DiscountCalculator/src/discountcalculator
         */

        // Declared paths to input and outputs file in the following variables.
        // Makes it easier to change it later.
        String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\DiscountCalculator\\src\\discountcalculator\\customers.txt";
        String outputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\DiscountCalculator\\src\\discountcalculator\\customerdiscount.txt";

        // Call readInputFile method to read an input file.
        readInputFile(inputFilePath, outputFilePath);
    }

    /**
     * This method is used to read the data from an input file and convert in
     * into a Customer object.
     *
     * @param inputFilePath path to the input file
     * @param outputFilePath path to the output file
     */
    private static void readInputFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            // I create a writer object at the top of the method with false path property 
            // to overwrite an input file if it already exists
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, false));

            // Declare a userName variable
            String customerName;

            // Use while block to read the data from the file until we reach an end of the file
            while ((customerName = bufferedReader.readLine()) != null) {
                // If we successfully found a username from an input file,
                // read other fields and store them in corresponding variables
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
                    
                    if (!validateCustomerName(customerName)) {
                        continue;
                    }

                    // Create a new customer with the data read from the input file.
                    Customer customer = new Customer(customerName, baseValue, customerClass, lastPurchaseYear);

                    // Call writeOutputFile method to populate output file with proper data
                    writeOutputFile(customer, outputFilePath);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Method used to create and populate output file with customer name and
     * final purchase values.
     *
     * @param outputFilePath path to the output file
     */
    private static void writeOutputFile(Customer customer, String outputFilePath) {
        try {
            // Create a writer object which is used to add data to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true));
            // And user name on the first line
            writer.write(customer.getName());
            // Move cursor to the new line
            writer.newLine();
            // Repeat process for the final value calculated in a Customer object
            writer.write(Double.toString(customer.getFinalValue()));
            writer.newLine();
            // Close the file after we are done writing into it
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method validates if provided customer name is valid.
     * Check if customer name contains a space, 
     * customer first name has only lowercase and uppercase letters
     * and customer last name has only lowercase, uppercase letters or numbers
     *
     * @param customerName customer name read from an input file
     */
    private static boolean validateCustomerName(String customerName) {
        // Check if customer name contains a space
        if (!customerName.contains(" ")){
            // Show error message and return false if it doesn't
            System.err.println("Customer name must contain a space: " + customerName);
            return false;
        }
        
        // Split customer name into first name and last name
        String firstName = customerName.split(" ")[0];
        String lastName = customerName.split(" ")[1];

        // Check if customer first name matches requied critea
        if (!firstName.matches("[a-zA-Z]+")) {
            // Show error message and return false if it doesn't
            System.err.println("Invalid first name for customer: " + customerName);
            return false;
        }

        // Check if customer first name matches requied critea
        if (!lastName.matches("[a-zA-Z0-9]+")) {
            // Show error message and return false if it doesn't
            System.err.println("Invalid surname name for customer: " + customerName);
            return false;
        }

        // Return true if customer name is valid
        return true;
    }
}
