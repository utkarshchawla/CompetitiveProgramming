package assignment_4;

import java.util.Scanner;

public class ques14 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] s1 = takeinput();
		display(s1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int[] s2 = takeinput();
		display(s2);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		display(sumArr(s1, s2));

	}

	public static int[] takeinput() {
		System.out.println("enter the length of the array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter the " + i + " th element");
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	public static int[] sumArr(int[] arr1, int[] arr2) {

		int l1 = arr1.length;
		int l2 = arr2.length;
		int l = 0;

		if (l1 > l2) {
			l = l1;
		} else {
			l = l2;
		}
		int[] s = new int[l];
		int sum = 0;
		int carry = 0;
		int a = 0;
		int b = 0;

		for (int i = 0; i < l; i++) {

			if (l2 - 1 - i >= 0) {
				b = arr2[l2 - 1 - i];
			} else {
				b = 0;
			}

			if (l1 - 1 - i >= 0) {
				a = arr1[l1 - 1 - i];
			} else {
				a = 0;
			}

			int rem = 0;
			sum = a + b + carry;
			rem = (sum) % 10;
			carry = (sum) / 10;
			s[l - 1 - i] = rem;

		}

		return s;
	}
}