package arrays.challenge01;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Arrays: 2D Arrays

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        // Initialize variables
        int arrayWidth = 6;
        int arrayLength = 6;
        int hourglassSum;
        int maxSum = Integer.MIN_VALUE;

        // Nested for-loop to go through each relevant center points in array
        for (int i = 1; i < arrayWidth - 1; i++) {
            for (int j = 1; j < arrayLength - 1; j++) {
                // Calculate sum of hourglass
                hourglassSum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
                    + arr[i][j]
                    + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                // Compare to the maximum sum
                if (hourglassSum > maxSum) {
                    maxSum = hourglassSum;
                }
            }
        }

        // Return the maximum sum
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
