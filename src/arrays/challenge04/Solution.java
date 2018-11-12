package arrays.challenge04;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Arrays: Minimum Swaps

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        // Initialize variables
        int numSwaps = 0;
        int arrayLength = arr.length;
        
        // Create a sorted array to compare to unsorted
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        HashMap<Integer, Integer> refMap = new HashMap<Integer, Integer>();
        
        // Create a HashMap designating the locations of the actual values
        for (int j = 0; j < arrayLength; j++) {
            refMap.put(arr[j], sortedArray[j]-1);
        }

        // For loop to examine each element in the unsorted array
        for (int i = 0; i < arrayLength; i++) {
            // Conditional statement to address when the unsorted array does not match the sorted
            if (arr[i] != sortedArray[i]) {    
                // Grab the indices in the hashmap of both the sorted and unsorted arrays
                int sortedIndex = refMap.get(sortedArray[i]);
                int unsortedIndex = refMap.get(arr[i]);
                
                // Update the map to have values in the key so that the map reflects a swap
                refMap.put(arr[i], sortedIndex);
                refMap.put(sortedArray[i], unsortedIndex);

                // Assign the swapped values to the right position in the array
                int temp = arr[i];
                arr[refMap.get(arr[i])] = temp;
                arr[i] = sortedArray[i];

                // Increment number of swaps
                numSwaps++;
            }   
        }

        // Return total number of swaps
        return numSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}