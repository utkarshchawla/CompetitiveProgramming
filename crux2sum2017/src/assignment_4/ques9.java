package assignment_4;

import java.util.Scanner;

public class ques9 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] s = takeinput();
		display(s);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		selectionsort(s);
		display(s);

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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

}
