package warmup.challenge03;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Warm-Up Challenge: Jumping on the Clouds

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

//         // Initialize variables
//         int counter = 0;
//         int allowableHops = 2;
//         int numSteps = 0;
        
//         for (int i = 0; i <= c.length - 1; i++) {
//             if (i != 0) {
//                 if (c[i] == 0) {
//                     if (counter < allowableHops) {
//                         numSteps++;
//                         System.out.println(c[i] + " numSteps: " + numSteps);
//                         counter++;
//                     }
//                     else {
//                         System.out.println(c[i] + " numSteps: " + numSteps);
//                         counter = 1;
//                     }
//                 }
//                 if (c[i] == 1) {
//                     //numSteps++;
//                     System.out.println(c[i] + " numSteps: " + numSteps);
//                     counter = 0;
//                 }
//             }
            
//             else {
//                 System.out.println(c[i] + " numSteps: " + numSteps);
//                 counter++;
//             }

//         }
        
//         return numSteps;
        
        
        // Initialize variables
        int counter = 0;
        int allowableHops = 2;
        Stack<Integer> stepsToCount = new Stack<Integer>();
        
        // for each element in input array, evaluate
        for (int element : c) {
            // if one or two 0s, add one or two 0s to new array
            if (element == 0) {
                if (counter < allowableHops) {
                    stepsToCount.push(element);
                    // add one to the counter
                    counter++;
                }
                // if there are 3 consecutive 0s, leave as 2 and reset counter
                else {
                    // reset counter to 0;
                    counter = 1;
                }  
                
            }

            // if 1, add 1 to new array
            if (element == 1) {
                // reset counter to 0
                counter = 0;
            }
            
        }
        
        // return the size of the stack, as it is the number of hops
        return (stepsToCount.size() - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}