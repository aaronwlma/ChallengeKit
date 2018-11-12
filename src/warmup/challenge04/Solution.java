package warmup.challenge04;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        
        // Initiated variables
        char reviewedChar = 'a';
        long numReviewedCharInString = 0;
        long total = 0;
                
        // FULL STRING CHECK:
        // Count number of reviewedChars in s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == reviewedChar) {
                numReviewedCharInString++;
            }
        }
        // Multiply that value by the number of times s repeats fully and set it to total
        total = numReviewedCharInString * (n / s.length());
        
        // REMAINDER STRING CHECK:
        // If a remainder exists, we check for the reviewedChar up until the remainder
        if (n % s.length() != 0) {
            // for loop to checks each relevant character for reviewedChar
            for (int i = 0; i < (int) (n % s.length()); i++) {
                if (s.charAt(i) == reviewedChar) {
                    total++;
                }
            }
        }

        // Return the total
        return total;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

