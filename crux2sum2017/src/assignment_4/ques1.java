package assignment_4;

import java.util.Scanner;

public class ques1 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println(maxval(takeinput()));
	}
	
	public static int[]  takeinput(){
		System.out.println("enter the length of the array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			System.out.println("enter the " + i + " th element");
			arr[i] = scn.nextInt();
		}
		return arr;
	}
	
	public static int maxval(int[] arr){
		int temp = arr[0];
		for(int i = 1; i <arr.length; i++){
			if(arr[i] > temp){
				temp = arr[i];
			}
		}
		return temp;
	}
	

}
