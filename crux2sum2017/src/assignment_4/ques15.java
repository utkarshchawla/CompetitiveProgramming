package assignment_4;

import java.util.Scanner;

public class ques15 {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        subset(arr);


    }


    public static void subset(int[] arr) {
        for (int i = 0; i < Math.pow(2, arr.length); i++) {
            int cnt = 0;
            int val = 0;
            int temp = i;
            while (temp != 0) {
                val += (temp % 2) * Math.pow(10, cnt);
                temp /= 2;
                cnt++;
            }
            cnt = 0;
            while (val != 0) {
                if (val % 10 == 1) {
                    System.out.print(arr[cnt] + " ");
                }
                val /= 10;
                cnt++;
            }
            System.out.println();
        }

    }

}

