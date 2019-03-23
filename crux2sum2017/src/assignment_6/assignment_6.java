package assignment_6;

import java.util.Scanner;

public class assignment_6 {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        // PDI(6);
//		 printInvTriangle(1, 1, 5);
        // System.out.println(triangle(10));
//		 pattern(7);
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(find(arr, 0, 6));
//        System.out.println(firstindex(arr, 0, 3));
        // display(arr, 0);
        // display(allindeces(arr, 0, 4, 0), 0);
        // System.out.println(isPalindrome(arr, 0, arr.length - 1));
        rev(arr, 0);
        // display(inv(arr, 0), 0);
        // display(bubble(arr, 0, arr.length - 1), 0);
//		display(select(arr, 1, 0), 0);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] arr, int vidx) {
        if (vidx == arr.length - 1) {
            System.out.println(arr[arr.length - 1]);
            return;
        }

        System.out.print(arr[vidx] + "\t");
        display(arr, vidx + 1);
    }

    public static void PDI(int n) {
        if (n == 0) {
            return;
        }

        if (n % 2 == 1) {
            System.out.println(n);

        }
        PDI(n - 1);

        if (n % 2 == 0) {
            System.out.println(n);
        }

    }

    public static void printTriangle(int row, int col, int n) {
        if (col > row) {
            System.out.println();
            printTriangle(row + 1, 1, n);
            return;
        }

        if (row > n) {
            return;
        }

        System.out.print("*");
        printTriangle(row, col + 1, n);
    }

    public static void printInvTriangle(int row, int col, int n) {
        if (col > row) {
            printInvTriangle(row + 1, 1, n);
            System.out.println();
            return;
        }

        if (row > n) {
            return;
        }

        printInvTriangle(row, col + 1, n);
        System.out.print("*");
    }

    public static int[] pattern(int n) {
        int[] pnm1 = new int[n - 1];
        int[] p = new int[n];
        if (n == 1) {
            p[0] = 1;
            display(p, 0);
            return p;
        }

        pnm1 = pattern(n - 1);
        p[n - 1] = p[0] = 1;
        for (int i = 1; i < p.length - 1; i++) {
            p[i] = pnm1[i - 1] + pnm1[i];
        }
        display(p, 0);
        return p;

    }

    public static int triangle(int n) {

        if (n == 1) {
            return 1;
        }

        int ntm1 = triangle(n - 1);
        return ntm1 + n;
    }

    public static boolean isSorted(int[] arr, int vidx) {
        if (vidx == arr.length - 1) {
            return true;
        }
        if (arr[vidx] > arr[vidx + 1]) {
            return false;
        } else {
            return isSorted(arr, vidx + 1);
        }

        // boolean nm = isSorted(arr, vidx + 1);
        // if(nm){
        // if(arr[vidx] > arr[vidx + 1]){
        // return true;
        // } return false;
        // } return false;
    }

    public static boolean find(int[] arr, int vidx, int data) {
        if (vidx == arr.length) {
            return false;
        }

        if (arr[vidx] == data) {
            return true;
        }
        return find(arr, vidx + 1, data);

    }

    public static int firstindex(int[] arr, int vidx, int data) {
        if (vidx == arr.length) {
            return -1;
        }
        if (arr[vidx] == data) {
            return vidx;
        }
        return firstindex(arr, vidx + 1, data);

    }

    public static int lastindex(int[] arr, int vidx, int data) {
        if (vidx == arr.length) {
            return -1;
        }

        if (arr[vidx] == data && lastindex(arr, vidx + 1, data) == -1) {
            return vidx;
        }
        return lastindex(arr, vidx + 1, data);


    }

    public static int[] allindeces(int[] arr, int vidx, int data, int csf) {
        if (vidx == arr.length) {
            return new int[csf];
        }

        if (arr[vidx] == data) {
            int[] rr = allindeces(arr, vidx + 1, data, csf + 1);
            rr[csf] = vidx;
            return rr;
        } else {
            int[] rr = allindeces(arr, vidx + 1, data, csf);
            return rr;
        }

    }

    public static boolean isPalindrome(int[] arr, int vidx, int vfdx) {
        if (vidx == vfdx) {
            return true;
        }

        if (arr[vidx] != arr[vfdx]) {
            return false;
        }
        return isPalindrome(arr, vidx + 1, vfdx - 1);
    }

    public static void rev(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return;
        }

        rev(arr, vidx + 1);
        System.out.print(arr[vidx] + ", ");

    }

    public static int[] inv(int[] arr, int vidx) {
        int[] rr = new int[arr.length];
        if (vidx == arr.length) {
            return rr;
        }
        rr = inv(arr, vidx + 1);
        rr[vidx] = firstindex(arr, 0, vidx);

        return rr;
    }

    public static int[] bubble(int[] arr, int vidx, int vfdx) {
        if (vfdx == 0) {
            return arr;
        }

        if (vidx == vfdx) {
            arr = bubble(arr, 0, vfdx - 1);
            return arr;
        }

        if (arr[vidx] > arr[vidx + 1]) {
            swap(arr, vidx, vidx + 1);
        }
        arr = bubble(arr, vidx + 1, vfdx);

        return arr;

    }

    public static int[] select(int[] arr, int vidx, int cntr) {
        if (cntr == arr.length - 1) {
            return arr;
        }
        if (vidx == arr.length) {
            vidx = 1;
            arr = select(arr, vidx + cntr + 1, cntr + 1);
            return arr;
        }
        if (arr[cntr] > arr[vidx]) {
            swap(arr, vidx, cntr);
        }
        arr = select(arr, vidx + 1, cntr);
        return arr;
    }

    public static void inv2(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return;
        }
        int temp = arr[vidx];
        inv(arr, vidx + 1);
        arr[temp] = vidx;
    }
}
