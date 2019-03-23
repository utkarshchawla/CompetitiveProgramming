package assignment_4;

import java.util.Scanner;

public class ques17 {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {

		int[][] arr = { { 11,12,13,14 }, { 21,22,23,24 },{ 31,32,33,34 }, { 41,42,43,44 } };
		rowdisplay(arr);
	}
	
	
	public static  void rowdisplay(int[][] arr){
		for(int row = 0; row < arr.length; row++)
		{
			if(row%2 == 0){
				for(int col = 0; col < arr[0].length; col++){
					System.out.print(arr[row][col] + ", ");
				}} else {
					for(int col = arr[0].length - 1; col >=0; col--){
						System.out.print(arr[row][col] + ", ");
					}
			}
		}
	}
}
