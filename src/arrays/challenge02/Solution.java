package arrays.challenge02;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Arrays: Left Rotation

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        
        // Initialize variables
        int[] rotatedArray = new int[a.length];
        
        // For loop that evaluates each element in the given array
        for (int i = 0; i < a.length; i++) {
            // See how many positions to move the element, then copies into a new array
            // if the element needs to be moved to the back, move to back
            if (i - d < 0) {
                rotatedArray[a.length - Math.abs(i - d)] = a[i];
            }
            // if its only just shifting to the left, shift the values to the left
            else {
                rotatedArray[i - d] = a[i];
            }
        }

        // Return the rotated array
        return rotatedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

