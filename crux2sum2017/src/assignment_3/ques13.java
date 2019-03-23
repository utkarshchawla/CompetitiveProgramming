package assignment_3;

import java.util.Scanner;

public class ques13 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the power");
		int p = scn.nextInt();
		scn.close();
		System.out.println(power(n, p));
	}
	
	public static int power(int n, int p){
		int counter = 1;
		int val = 1;
		while(counter <= p){
			val = val*n;
			counter++;
		}
		return val;
	}

}
