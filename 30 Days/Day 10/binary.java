import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String temp = Integer.toBinaryString(n);
        char[] binary = temp.toCharArray();
        int count=0;
        int max=0; 
        for(int i=0;i<binary.length;i++){
            if(binary[i]=='1'){
                count++;
            }else{
                count = 0;
            }
            if(count>max){
                max = count;
            }
        }
        System.out.print(max);

        scanner.close();
    }
}

