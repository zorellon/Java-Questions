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
        long numberAs = 0;
        if (n > s.length()) {
            long repeat = n / s.length();
            long diff = n % repeat;
            for (char c : s.toCharArray()) {
                if (c == 'a')
                    numberAs++;
            }
            numberAs = numberAs * repeat;
            for (int i = 0; i < diff; i++) {
                if (s.charAt(i) == 'a')
                    numberAs++;
            }
        } else {
            int len = (int) n;
            s = s.substring(0, len + 1);
            for (char c : s.toCharArray()) {
                if (c == 'a')
                    numberAs++;
            }
        }
        return numberAs;
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
