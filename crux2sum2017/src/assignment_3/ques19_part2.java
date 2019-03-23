package assignment_3;

import java.util.Scanner;

public class ques19_part2 {

	public static void main(String[] args) {
	Scanner scn =  new Scanner(System.in);
	int n = scn.nextInt();
	int[] s = new int[n];
	for(int i = 0; i < s.length; i++){
		s[i] = scn.nextInt();
	}
	
	System.out.println(split(s));
	}
	public static boolean split(int[] arr){
		int counter = 0;
		for(int i = 0; arr[i] > arr[i + 1]; i++){
			
			if(i == arr.length -2){
				return true;
			}else{
				counter++;
			}
		}
			counter++;
		for(int i = counter; arr[i] < arr[i + 1]; i++){
			
			if(i == arr.length - 2){
				return true;
			}
			
		}
		return false;
			
		}
	}

