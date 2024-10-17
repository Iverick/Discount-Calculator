/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package discountcalculator;

/**
 *
 * @author User
 */
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

        calculateDiscount();
        calculateFinalValue();
    }
    
    // This method calculates the discout based on the year of the last purchase and customer class.
    // TODO: Implement function to calculate proper discount.
    private void calculateDiscount() {
        this.discount = 0.9;
    }
    
    // This method calculates the final value based on the base value and the customer class.
    private void calculateFinalValue() {
        this.finalValue = this.baseValue * this.discount;
    }
    
    // Getters methods
    public String getName() {
        return this.name;
    }
    
    public double getBaseValue() {
        return this.baseValue;
    }
    
    public double getFinalValue() {
        return this.finalValue;
    }
}
