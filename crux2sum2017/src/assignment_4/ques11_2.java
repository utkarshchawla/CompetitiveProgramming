package assignment_4;

import java.util.Scanner;

public class ques11_2 {
	
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {

		int n = scn.nextInt();
		int[] arr1 = takeinput(n);
		insertionsort(arr1);
		int[] arr2 = takeinput(n);
		insertionsort(arr2);

		display(intersect(arr1, arr2));
		
	}
	
	public static void display(int[] arr){ 
		System.out.print("[");
		for(int i = 0;i < arr.length; i++){
			if(i == arr.length - 1){
				System.out.print(arr[i]);
			}else{
				System.out.print( arr[i] + ", ");

			}
		}
		System.out.print("]");
	}
	
	public static int[] intersect(int[] arr1,int[] arr2){
		
		int counter = 0;
		int[] s;
		int i = 0, j = 0, k = 0;
		while(i < arr1.length && k < arr2.length){
			if(arr1[i] < arr2[k]){
				i++;
			} else if( arr1[i] > arr2[k]){
				k++;
			} else{
				counter++;
				i++;
				k++;
				j++;
			}
		}
		s = new int[counter];
		 i = 0;
		 j = 0;
		 k = 0;
		while(i < arr1.length && k < arr2.length){
			if(arr1[i] < arr2[k]){
				i++;
			} else if( arr1[i] > arr2[k]){
				k++;
			} else{
				s[j] = arr1[i];
				i++;
				k++;
				j++;
			}
		}
		return s;
	}
	
	public static void insertionsort(int[] arr){
		int counter = 1;
		while(counter < arr.length){
			for(int i = counter - 1; i >= 0; i--){
				if(arr[i + 1] < arr[i]){
					swap(arr, i + 1, i);
				}
			}
			counter++;
		}
	}
	
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] takeinput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
