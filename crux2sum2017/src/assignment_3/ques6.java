package assignment_3;

import java.util.Scanner;

public class ques6 {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the digit");
		int d = scn.nextInt();
		scn.close();
		
		int x = repeat(n, d);
		System.out.println(x);

	}
	public static int repeat(int n,int d){
		int counter = 0;
		int val = 0;
		while(n != 0){
			val = n%10;
			if(val == d){
				counter++;
			}
			n = n/10;
		}
		return counter;
	}

	
}
