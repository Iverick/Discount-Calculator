package discountcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Year;

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
        // Makes it easier to change them later.
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
                try {
                    // Call validateCustomerName method to check if provided customerName value
                    // fulfills requied criteria.
                    // I had to do it differently from other fields because customerName variable has
                    // already been assigned with value at this point.
                    if (!validateCustomerName(customerName)) {
                        // Stop executing loop if validation failed
                        continue;
                    }

                    // Use validateBaseValue method to check if baseValue can be converted into a double
                    double baseValue = validateBaseValue(customerName, baseValueString);
                    // Use validateCustomerClass method to validate customerClass value and convert in into an integer
                    int customerClass = validateCustomerClass(customerName, customerClassString);
                    // Use validatePurchaseYear method to validate that a lastPurchaseYear value is valid and convert in into an integer
                    int lastPurchaseYear = validatePurchaseYear(customerName, lastPurchaseYearString);

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

            // Add user name on the first line
            writer.write(customer.getName());
            // Move cursor to the new line
            writer.newLine();
            // Repeat process for the converted final value
            writer.write(customer.getConvertedFinalValue());
            writer.newLine();
            // Close the file after we are done writing into it
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method validates if provided customer name is valid. Check if
     * customer name contains a space, customer first name has only lowercase
     * and uppercase letters and customer last name has only lowercase,
     * uppercase letters or numbers
     *
     * @param customerName customer name read from an input file
     * @return             if provided customer name passed validation
     */
    private static boolean validateCustomerName(String customerName) {
        // Check if customer name contains a space
        if (!customerName.contains(" ")) {
            // Show error message and return false if it doesn't
            System.err.println("Customer name must contain a space: " + customerName);
            return false;
        }

        // Split customer name into first name and last name
        String firstName = customerName.split(" ")[0];
        String lastName = customerName.split(" ")[1];

        // Use regular expression to check if customer first name matches requied criteria
        if (!firstName.matches("[a-zA-Z]+")) {
            // Show error message and return false if it doesn't
            System.err.println("Invalid first name for customer: " + customerName);
            return false;
        }

        // Use regular expression to check if customer first name matches requied criteria
        if (!lastName.matches("[a-zA-Z0-9]+")) {
            // Show error message and return false if it doesn't
            System.err.println("Invalid surname name for customer: " + customerName);
            return false;
        }

        // Return true if customer name is valid
        return true;
    }

    /**
     * This method validates if provided base value of purchase can be converted into a double.
     *
     * @param customerName    customer name read from an input file
     * @param baseValueString base value of purchase read from an input file
     * @return baseValue      customer class converted into integer value
     */
    private static double validateBaseValue(String customerName, String baseValueString) {
        try {
            // Try to convert baseValueString value into a double
            double baseValue = Double.parseDouble(baseValueString);

            // Return baseValue value
            return baseValue;
        } catch (NumberFormatException e) {
            // Custom error message displayed if validation failed
            throw new NumberFormatException("Invalid value of purchase for: " + customerName + ". Provided value must a number: " + baseValueString);
        }
    }
    
    /**
     * This method validates if provided customer class is a number between 1 and 3.
     *
     * @param customerName        customer name read from an input file
     * @param customerClassString customer class read from an input file
     * @return customerClass      customer class converted into integer value
     */
    private static int validateCustomerClass(String customerName, String customerClassString) {
        // Cover code into a try/catch block to show a custom error message
        // and stop executing function if provided customer class value is invalid.
        try {
            // Try to convert customerClass value into integer
            int customerClass = Integer.parseInt(customerClassString);

            // Check if customerClass value between 1 and 3
            if (customerClass < 1 || customerClass > 3) {
                // Throw exception if it doesn't
                throw new NumberFormatException();
            }

            // Return customerClass value
            return customerClass;
        } catch (NumberFormatException e) {
            // Custom error message displayed if validation failed
            throw new NumberFormatException("Invalid class for customer: " + customerName + ", it must be a number between 1 and 3!");
        }
    }

    /**
     * This method validates if provided last purchase year class is a valid
     * year value between 2000 and now, and coverts value into an integer.
     *
     * @param customerName customer name read from an input file
     * @param lastPurchaseYearString last purchase year for customer read from an input file
     * 
     * @return lastPurchaseYear last purchase year for customer converted into integer value
     */
    private static int validatePurchaseYear(String customerName, String lastPurchaseYearString) {
        // Cover code into a try/catch block to show a custom error message
        // and stop executing function if provided last purchase year value is invalid.
        try {
            // Try to convert lastPurchaseYear value into an integer
            int lastPurchaseYear = Integer.parseInt(lastPurchaseYearString);

            // Use built-in Java library to get a current year value
            int currentYear = Year.now().getValue();

            // Check if lastPurchaseYear value is between 2000 and now
            if (lastPurchaseYear < 2000 || lastPurchaseYear > currentYear) {
                // Throw NumberFormatException exception if it doesn't
                throw new NumberFormatException();
            }

            // Return lastPurchaseYear value
            return lastPurchaseYear;
        } catch (NumberFormatException e) {
            // Custom error message displayed if validation failed
            throw new NumberFormatException("Invalid purchase year for customer: " + customerName + ", please enter a valid year between 2000 and now!");
        }
    }
}
