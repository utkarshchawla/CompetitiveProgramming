package assignment_4;

import java.util.Scanner;

public class ques19 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };

		// int[][] arr = takeinput2d();
		spiralAC(arr);
	}

	public static int[][] takeinput2d() {
		System.out.println("enter the no. of rows");
		int row = scn.nextInt();
		System.out.println("enter the no. of col");
		int col = scn.nextInt();

		int[][] arr = new int[row][col];
		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length; col++) {
				System.out.println("enter " + row + ", " + col + " element");
				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void spiralAC(int[][] arr) {
		int dir = 0;
		int rowMin = 0, rowMax = arr.length - 1;
		int colMin = 0, colMax = arr[0].length - 1;
		int row = 0, col = 0;
		int counter = 1;

		while (counter <= (arr.length * arr[0].length)) {
			if (dir == 0) {
				System.out.print(arr[row][col] + ", ");
				counter++;
				row++;
				if (row == rowMax) {
					dir = 3;
				}
			}
			if (dir == 3) {
				System.out.print(arr[row][col] + ", ");
				counter++;
				col++;
				if (col == colMax) {
					dir = 2;
				}
			}
			if (dir == 2) {
				System.out.print(arr[row][col] + ", ");
				counter++;
				row--;
				if (row == rowMin) {
					dir = 1;
				}
			}
			if (dir == 1) {
				System.out.print(arr[row][col] + ", ");
				counter++;
				col--;
				if (col == colMin) {
					dir = 0;
					rowMin++;
					rowMax--;
					colMax--;
					colMin++;
					row++;
					col++;
				}
			}

		}

	}
}
