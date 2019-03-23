package assignment_2;

import java.util.Scanner;

public class ass2ques15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a number");
        int n = scn.nextInt();
        int r = 1;
        int nsp = 2 * n - 3;

        while (r <= n) {
            int c = 1;
            while (c <= r) {
                System.out.print(c);
                c++;
            }
            int csp = 1;
            while (csp <= nsp) {
                System.out.print(" ");
                csp++;
            }
            nsp -= 2;
            int m = 1;
            int val = r;
            if (r == n) {
                val = r - 1;
                m = 2;
            }
            while (m <= r) {
                System.out.print(val);
                val--;
                m++;
            }
            r++;
            System.out.print("\n");
        }

    }

}
