package june_12;

import java.util.Scanner;

public class funpowlog {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter number");
        int x = scn.nextInt();
        System.out.println("enter base");
        int n = scn.nextInt();
        scn.close();
        log(x, n);
    }

    public static int power(int x, int n) {
        int pow = (int) (Math.pow(x, n));
        return pow;
    }

    public static void log(int x, int n) {
        int val = 0;
        int counter = 0;
        while (val != x) {
            val = power(n, counter);
            counter++;
        }
        System.out.println("log : " + (counter - 1));
    }

}
