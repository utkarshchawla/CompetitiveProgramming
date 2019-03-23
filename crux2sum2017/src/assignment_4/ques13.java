package assignment_4;

import java.util.Scanner;

public class ques13 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] s = takeinput();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		sum(s, 9);
	}

	public static void sum(int[] arr, int target) {
		int counter = 0;
		while (counter < arr.length - 2) {
			for (int i = counter + 1; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length ; j++) {
					if ((arr[counter] + arr[j] + arr[i]) == target) {
						System.out.println(arr[counter ] + ", " + arr[j] + ", " + arr[i]);
					}
				}

			}
			counter++;
		}

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
			System.out.println(arr[i] + "\t");
		}
	}

}