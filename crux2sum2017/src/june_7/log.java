package june_7;//package crux2sum2017;

import java.util.Scanner;

public class log {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter base");
        int b = scn.nextInt();
        System.out.println("enter value");
        int n = scn.nextInt();
        scn.close();

        int counter = 1;
        while (n / b != 1) {
            n = n / b;
            counter++;
        }
        System.out.println(counter);
    }

}
