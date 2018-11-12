package arrays.challenge03;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Arrays: New Year Chaos

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        // Initialize variables
        int numSwaps = 0;
        boolean tooChaotic = false;
        
        // For loop to go through each value from 0 to the end
        for (int i = q.length-1; i >= 0; i--) {
            // Check if the value is a possible value
            if (q[i] - (i + 1) > 2) {
                tooChaotic = true;
                break;
            }
            // For loop to check if someone overtook someone
            for (int j = Math.max(0, q[i]-2); j < i; j++) {
                if (q[j] > q[i]) {
                    numSwaps++;
                }
            }
        }
        
        // Conditional statement to print out proper output
        if (tooChaotic == true) {
            System.out.println("Too chaotic");
        }
        else {
            System.out.println(numSwaps);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
