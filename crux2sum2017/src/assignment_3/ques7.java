package assignment_3;

import java.util.Scanner;

public class ques7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		scn.close();
		int counter = 0;
		int val = 0;
		while(n != 0){
			counter++;
			int x = n%10;
			val += counter * (int)(Math.pow(10, x - 1));
			n = n/10;
		}
		System.out.println(val);
	}

}
