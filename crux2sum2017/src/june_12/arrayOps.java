package june_12;

import java.util.Scanner;

public class arrayOps {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
//		int[] y = {2,4,0,10,3};
//		display(y);
//		reverse(y);
//		display(y);

        takeinput();

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

    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.println(val + "\t");
        }
        System.out.println();
    }

    public static int max(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public static int linearSearch(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public static void reverse(int arr[]) {
        int l = arr.length;
        int[] rev = new int[l];
        for (int i = 0; i < l; i++) {
            rev[i] = arr[l - 1 - i];
        }
        for (int i = 0; i < l; i++) {
            arr[i] = rev[i];
        }

    }

    public static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            inv[arr[i]] = i;
            i++;
        }

        return inv;
    }

    public static int[] rotate(int[] rotate, int k) {

        k = k % rotate.length;
        if (k < 0) {
            k += rotate.length;
        }

        int[] rot = new int[rotate.length];
        int j = 0;

        for (int i = (rotate.length - k); i < rotate.length; i++) {
            rot[j] = rotate[i];
            j++;
        }
        for (int i = 0; i < rotate.length - k; i++) {
            rot[j] = rotate[i];
            j++;
        }
        return rot;
    }
}

