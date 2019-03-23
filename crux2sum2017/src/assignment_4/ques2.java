package assignment_4;

import java.util.Scanner;

public class ques2 {
	
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {

		int[] s = takeinput();
		System.out.println("enter the element");
		int m = scn.nextInt();
		
		System.out.println(linearsearch(s, m));
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
	
	public static int linearsearch(int[] arr,int m){
		for(int i = 0; i<arr.length; i ++){
			if(arr[i] == m){
				return i;
			}
		}
		return -1;
	}
}
