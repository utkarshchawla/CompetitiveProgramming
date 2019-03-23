package assignment_4;

import java.util.Scanner;

import june_14.binarysearch;

class ques3 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] s = takeinput();
		System.out.println("enter the element");
		int m = scn.nextInt();
		System.out.println(binrysearch(s, m));

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

	public static int binrysearch(int[] arr, int m){
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			
			if(m > arr[mid]){
				lo = mid + 1;
			} else if(m < arr[mid]){
				hi = mid -1;
			} else{
				return mid;
			}	
			
		}
		return -1;
	}
	
}
