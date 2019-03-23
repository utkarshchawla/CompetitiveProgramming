package june_14;

import java.util.Scanner;

public class sort {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = {55, 44, 22, 33, 11, 20, 30, 30};
        //bubblesort(arr);
        insertionsort(arr);
        //selectionsort(arr);
        display(arr);

    }

    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.println(val + "\t");
        }
        System.out.println();
    }

    public static int[] takeinput() {

        System.out.println("enter the string of the array");
        int n = scn.nextInt();
        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            System.out.println("enter the value of" + i + "th element");
            rv[i] = scn.nextInt();
        }
        return rv;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void bubblesort(int[] arr) {
        int counter = 1;
        while (counter <= arr.length - 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            counter++;
        }
    }

    public static void selectionsort(int[] arr) {

        int counter = 1;
        while (counter < arr.length) {
            for (int i = counter; i < arr.length; i++) {
                if (arr[counter - 1] > arr[i]) {
                    swap(arr, counter - 1, i);
                }
            }
            counter++;
        }
    }

    public static void insertionsort(int[] arr) {

        int counter = 1;
        while (counter < arr.length) {
            for (int i = counter; i > 0; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                } else {
                    break;
                }
            }
            counter++;
        }
    }


}
