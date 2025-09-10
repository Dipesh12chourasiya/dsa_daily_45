// Java Code to print duplicate characters 
// and their counts using Sorting 

// https://www.geeksforgeeks.org/dsa/print-all-the-duplicates-in-the-input-string/

import java.util.*;

class GfG {

    // Function to print duplicate characters with their count
    static void printDuplicates(String s) {

        // Convert string to character array
        char[] arr = s.toCharArray();

        // Sort the string to group same characters together
        Arrays.sort(arr);

        // Traverse the sorted string to count duplicates
        for (int i = 0; i < arr.length;) {

            int count = 1;

            // Count occurrences of current character
            while (i + count < arr.length && arr[i] == arr[i + count]) {
                count++;
            }

            // If count > 1, print the character and its count
            if (count > 1) {
                System.out.print("['" + arr[i] + "', " + count + "], ");
            }

            // Move to the next different character
            i += count;
        }
    }

    public static void main(String[] args) {

        String s = "geeksforgeeks";

        printDuplicates(s);
    }
}