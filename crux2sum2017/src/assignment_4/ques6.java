package assignment_4;

import java.util.Scanner;

public class ques6 {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		int[] s = takeinput();
	    display(s);
	    System.out.println(inverse(s));
	
		
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
	
	public static void display(int[] arr){ 
		for(int i = 0;i < arr.length; i++){
			System.out.println(arr[i] + "\t");
		}
	}
	
	
	public static boolean inverse(int[] arr){
		int[] inv = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			inv[arr[i]] = i;
		}
		return ismirror(arr, inv);
	}
	
	public static boolean ismirror(int[] arr1, int[] arr2){
		for(int i = 0; i < arr1.length; i++){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}

}
