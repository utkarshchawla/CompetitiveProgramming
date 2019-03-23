package assignment_4;

import java.util.Scanner;

public class ques18 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
		rowdisplay(arr);
	}

	public static void rowdisplay(int[][] arr) {
		for (int col = 0; col < arr.length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + ", ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + ", ");
				}
			}
		}
	}
}