package assignment_4;

import java.util.Scanner;

public class test {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		
		
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
}


