package QL;

import java.io.*;
import java.util.Scanner;

public class SPREAD2 {

    public static void main(String[] args) throws IOException {
        Scanner fr = new Scanner(System.in);
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            long[] sum = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
            }
            sum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                sum[i] = arr[i] + sum[i - 1];
            }
            long ans = 0;
            long reach = 0;
            while (reach < sum.length - 1) {
//                reach = reach + sum[(int) reach];
                reach += sum[(int) reach];
                ans++;
            }
            System.out.println(ans);
        }
    }
}
