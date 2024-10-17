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
            while ((userName = bufferedReader.readLine()) != null) {
                System.out.println(userName);
            }
        } catch (Exception e ) {
            System.err.println(e);
        }
    }
    
}
