/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author User
 */
public class CA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(checkArrayForDuplicates());
    }
    
    // Task 1: Array Search – Find the First Repeated Element
    private static String checkArrayForDuplicates() {
        // Ask user to create an array
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter length of an array:");
        int arrLength = sc.nextInt();
        
        int[] inputArray = new int[arrLength];
        Set<Integer> helperSet = new HashSet<>();
                
        // Use for loop to ask user to enter array numbers
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Please enter an array number:");
            int number = sc.nextInt();
            inputArray[i] = number;
        }
        
        // Display user's array with provided values
        System.out.println("Your array is: ");
        for (int i = 0; i < arrLength; i++) {
            System.out.println(inputArray[i]);
        }
        
        // Use for loop to iterate over array entries
        for(int i = 0; i < inputArray.length; i++) {
            // Check if a number has already been added to the Set of array numbers.
            // Continue this loop until it founds a duplicate.
            if (helperSet.contains(inputArray[i])) {
                return "Your array has repeated element: " + inputArray[i];
            } else {
                helperSet.add(inputArray[i]);
            }
        }
        
        return "No repeated elements found.";
    }
}
