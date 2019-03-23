package assignment_2;

import java.util.Scanner;

public class ass2ques10 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a number");
        int n = scn.nextInt();
        int r = 1;
        int a = 0;
        int b = 1;

        while (r <= n) {
            int c = 1;
            while (c <= r) {
                System.out.print(a + " ");
                int val = a + b;
                a = b;
                b = val;
                c++;
            }


            r++;
            System.out.print("\n");
        }

    }

}
