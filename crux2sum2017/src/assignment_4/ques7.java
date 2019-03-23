package assignment_4;

import java.util.Scanner;

public class ques7 {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("enter the length of the array");
		int n = scn.nextInt();

		int[] s1 = takeinput(n);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int[] s2 = takeinput(n);
		
	    System.out.println(inverse(s1,s2));
	
		
	}
	
	public static int[]  takeinput(int n){
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
	
	
	public static boolean inverse(int[] arr1, int[] arr2){
		int[] inv = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++){
			inv[arr1[i]] = i;
		}
		return ismirror(arr2, inv);
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
