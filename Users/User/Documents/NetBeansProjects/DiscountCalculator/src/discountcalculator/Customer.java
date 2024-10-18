package discountcalculator;

import java.time.Year;


public class Customer {
    // List of Customer's properties
    private String name;
    private int lastPurchaseYear;
    private int customerClass;
    private double baseValue;
    private double discount;
    private double finalValue;

    // Construcor for the Person object.
    // Sets object properties based on the data we read from the input file.
    public Customer(String name, double baseValue, int customerClass, int lastPurchaseYear) {
        this.name = name;
        this.baseValue = baseValue;
        this.customerClass = customerClass;
        this.lastPurchaseYear = lastPurchaseYear;

        // Call local methods to calculate discount and final value
        calculateDiscount();
        calculateFinalValue();
    }

    // This method calculates the discout based on the year of the last purchase and customer class.
    private void calculateDiscount() {
        // Assign currentYear to a distinct variable to make it easier to change later
        int currentYear = 2024;

        // Use switch to loop through the set of customer classes
        switch (this.customerClass) {
            case 1 -> {
                // Use if/else condition for each customer class to set a specific discount
                // based on the year of the last purchase
                if (this.lastPurchaseYear == currentYear) {
                    // If the last purchase has been made this year
                    this.discount = 0.3;
                } else if (this.lastPurchaseYear < currentYear && this.lastPurchaseYear >= currentYear - 5) {
                    // If the last purchase has been made more than 1 and less than 5 years ago
                    this.discount = 0.2;
                } else if (this.lastPurchaseYear < currentYear - 5) {
                    // If the last purchase has been made more than 5 years ago
                    this.discount = 0.1;
                }
            }
            case 2 -> {
                if (this.lastPurchaseYear == currentYear) {
                    this.discount = 0.15;
                } else if (this.lastPurchaseYear < currentYear && this.lastPurchaseYear >= currentYear - 5) {
                    this.discount = 0.13;
                } else if (this.lastPurchaseYear < currentYear - 5) {
                    this.discount = 0.05;
                }
            }
            case 3 -> {
                if (this.lastPurchaseYear == currentYear) {
                    this.discount = 0.03;
                } else {
                    this.discount = 0;
                }
            }
            default -> throw new IllegalArgumentException("Illegal class value: " + this.customerClass + ", for user: " + this.name);
        }
    }

    // This method calculates the final value based on the base value and the discount.
    private void calculateFinalValue() {
        this.finalValue = this.baseValue * (1 - this.discount);
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public double getFinalValue() {
        return this.finalValue;
    }
}
