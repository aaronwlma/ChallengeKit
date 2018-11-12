package warmup.challenge01;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Warm-Up Challenge: Sock Merchant

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        
        // Declare variables
        int counter = 1;
        int numPairs = 0;
        
        // Sort the array
        Arrays.sort(ar);
        
        // For each identical element in the array
        for (int i = 1; i < n; i++) {
            
            // If the element in question is the same as the previous
            if (ar[i] == ar[i-1]) {
                // Tally up the number of same elements as they come
                counter++;
            }
            // If not the same element, we finish tallying up for that element
            else {
                // Divide by two to count number of pairs
                numPairs += counter/2;
                // Restart the counter
                counter = 1;
            }
        }
        
        // Take care of the last comparison not accounted for in the for-loop
        numPairs += counter/2;
        
        // Return number of pairs after traversal
        return numPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}