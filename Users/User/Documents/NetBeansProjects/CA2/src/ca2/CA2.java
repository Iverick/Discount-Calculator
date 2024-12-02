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
        // System.out.println(checkArrayForDuplicates());
        // multiplicationTable();
        // diagonalSum();
        spiralTraversal();
        // bubbleSort();
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
    
    // Task 2: Multiplication Table Using 2D Array
    private static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        
        // Ask user for multiplication table size
        System.out.println("Enter size of multiplication table:");
        int size = sc.nextInt();
        
        // Create an empty 2D array of required size
        int[][] matrix = new int[size][size];
        
        // Loop through the array fields and populate them with proper values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        
        // Display multiplication table output
        System.out.println("Your multiplication table looks the following:");
        displayMatrix(matrix);
    }
    
    // Task 3: Diagonal Sum of a Matrix
    private static void diagonalSum() {
        Scanner sc = new Scanner(System.in);
        
        // Ask user for the number of rows and columns in matrix
        System.out.println("Enter number of matrix rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter number of matrix columns:");
        int cols = sc.nextInt();
        
        // Setup initial variables
        int[][] matrix = new int[rows][cols];
        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        
        // Use loop to populate matrix with user data
        System.out.println("Please enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Display matrix
        System.out.println("Your matrix is:");
        displayMatrix(matrix);
        
        // Loop through matrix to calculate main and secondary diagonal sums
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    mainDiagonalSum += matrix[i][j];
                }
                
                if (j == (cols - i - 1)) {
                    secondaryDiagonalSum += matrix[i][j];
                }
            }
        }
        
        // Display results to the user
        System.out.println("The sum of the main diagonal of this matrix is:");
        System.out.println(mainDiagonalSum);
        System.out.println("The sum of the secondary diagonal of this matrix is:");
        System.out.println(secondaryDiagonalSum);
    }
    
    // Task 4: Spiral Traversal of a Matrix
    private static void spiralTraversal() {
        Scanner sc = new Scanner(System.in);
        
        // Ask user for the number of rows and columns in matrix
        System.out.println("Enter number of matrix rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter number of matrix columns:");
        int cols = sc.nextInt();
        
        // Setup initial variables
        int[][] matrix = new int[rows][cols];
        // Following variables used to track whether we've reached an edge of matrix
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        
        // Use loop to populate matrix with user data
        System.out.println("Please enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Display matrix
        System.out.println("Your matrix is:");
        displayMatrix(matrix);
        
        // Use while loop to iterate through matrix entries until all its fields have been called
        // (e.g. left and right pointers are equal, so are top and bottom pointers)
        while (left < right && top < bottom) {
            // Iterate over upper row from left to right edges and display its value
            for (int i = left; i < right; i++) {
                System.out.println(matrix[top][i]);
            }
            
            // Increase top pointer because we no longer need to go through upper row
            top += 1;
            
            // Iterate over right column to the bottom
            for (int i = top; i < bottom; i++) {
                System.out.println(matrix[i][right - 1]);
            }
            
            // Move right pointer one point left
            right -= 1;
            
            // Break the loop if its already reached an end of matrix
            if (!(left < right && top < bottom)) break;
            
            // Iterate over bottom row from right side to left
            for (int i = right - 1; i > left - 1; i--) {
                System.out.println(matrix[bottom - 1][i]);
            }
            
            // Decrease bottom pointer because we no longer need to go through bottom row
            bottom -= 1;
            
            // Iterate over left column from bottom to top
            for (int i = bottom - 1; i > top - 1; i--) {
                System.out.println(matrix[i][left]);
            }
            
            // Move left pointer one point right 
            left += 1;
            // repeat cycle until we reach the last element in matrix
        }
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
    
    private static void displayMatrix(int[][] matrix) {
        // Helper method iterates over matrix fields and displays their values on the screen
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j] + "");
            }
            System.out.println(" ");
        }
    }
}
