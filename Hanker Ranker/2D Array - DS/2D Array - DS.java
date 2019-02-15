

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.

private static int hourglassSum(int[][] arr) {
    int maxRow = 6, maxCol = 6;
    int rowIndex = 0, columnIndex = 0;
    int maxValue = (-9) * 7; //Initialize to smallest possible number

    while(true) {
        //Calculate total value of houglass
        int rowOne = arr[rowIndex][columnIndex] + arr[rowIndex][columnIndex + 1] + arr[rowIndex][columnIndex + 2];
        int rowTwo = arr[rowIndex + 1][columnIndex + 1];
        int rowThree = arr[rowIndex + 2][columnIndex] + arr[rowIndex + 2][columnIndex + 1] + arr[rowIndex + 2][columnIndex + 2];
        int hourglassTotal = rowOne + rowTwo + rowThree;

        // Compare maxValue to latest hourglassTotal
        if((rowIndex == 0 && columnIndex == 0 ) || maxValue < hourglassTotal) {
            maxValue = hourglassTotal;
        }

        // Find next Hourglass location
        columnIndex++;
        if(columnIndex >= maxCol - 2) {
            rowIndex++;
            columnIndex = 0;
        }
        if(rowIndex >= maxRow - 2 )
            break;
    }
    return maxValue;
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
