package assignment_3;

import java.util.Scanner;

public class ques16 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number");
		int n = scn.nextInt();
		scn.close();
		System.out.println(sqrrt(n));
	}
	
	public static int sqrrt(int n){
		int s = (int)(Math.sqrt(n));
		return s;
	}

}
