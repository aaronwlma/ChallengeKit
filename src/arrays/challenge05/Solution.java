package arrays.challenge05;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Arrays: Array Manipulation

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        
        // Solution with Assistance from Discussion
        
        // Initialize variables
        long maxSum = 0;
        long sum = 0;
        int m = queries.length;
        long[] array = new long[n+1];
        
        // For each line in the input, add/subtract the edges to our 1D array        
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            array[a-1] += k;
            array[b] -= k;

        }

        // Find the maxSum by iterating through our array and finding the peak
        for (int j = 0; j < n; j++) {
            sum += array[j];
            maxSum = Math.max(maxSum, sum);
        }
        
        // Return the maximum sum
        return maxSum;

//        // My Personal Solution:

//         // Initialize variables
//         long maxSum = 0;
//         int[][] array = new int[queries.length][n+1];
        
//         // System.out.println(Arrays.deepToString(queries));
//         // System.out.println(Arrays.deepToString(array));
        
//         for (int i = 0; i < queries.length; i++) {
//             for (int j = queries[i][0]; j <= queries[i][1]; j++) {
//                 array[i][j] = queries[i][2];
//             }
//         }
        
//         // System.out.println(Arrays.deepToString(array));
        
//         for (int a = 0; a <= n; a++) {
//             long sum = 0;
//             for (int b = 0; b < array.length; b++) {
//                 // System.out.println(array[b][a]);
//                 sum += array[b][a];
//                 // System.out.println(sum);
//             }
//             // System.out.println();
//             if (sum >= maxSum) {
//                 maxSum = sum;
//             }
//             // System.out.println("MaxSum: " + maxSum);
//         }
               
//         return maxSum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}