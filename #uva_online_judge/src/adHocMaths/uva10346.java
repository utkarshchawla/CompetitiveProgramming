package adHocMaths;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva10346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int sum = n;
            while (n >= k) {
                int a = n / k;
                sum += a;
                n = n % k + a;
            }

            System.out.println(sum);
        }
    }
}
