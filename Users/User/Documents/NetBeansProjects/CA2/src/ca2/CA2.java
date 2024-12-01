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
        //System.out.println(checkArrayForDuplicates());
        bubbleSort();
    }
    
    // Task 1: Array Search – Find the First Repeated Element
    private static String checkArrayForDuplicates() {
        int[] inputArray = arrayCreator();
        Set<Integer> helperSet = new HashSet<>();
        
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
    
    // Task 5: Bubble Sort - Sorting an Array
    private static void bubbleSort() {
        // Initialize required variables
        int[] inputArray = arrayCreator();
        int numOfSwaps = 0;
        
        // Loop through the user array to perform sorting.
        // We need 2 loops for bubble sort - from start to the and from
        // selected element to end.
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                // Check if the element from the left side is greater than the element from the right.
                // Swap their places if that is true
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j + 1];
                    inputArray[j + 1] = inputArray[j];
                    inputArray[j] = temp;
                    numOfSwaps++;
                }
            }
        }
        
        // Loop through the array to display it in sorted order
        System.out.println("Sorted array looks the following:");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
        
        // Display the number of total swaps performed during sorting
        System.out.println("Total number of swaps made during the sorting:");
        System.out.println(numOfSwaps);
    }
    
    // Helper method used to create arrays for tasks 1 and 5
    private static int[] arrayCreator() {
        // Ask user to create an array of specific length
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter length of an array:");
        int arrLength = sc.nextInt();
        
        // Create an empty array
        int[] inputArray = new int[arrLength];
        
        // Use for loop to ask user to provide numbers and write them into the array
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
        
        return inputArray;
    }
}
