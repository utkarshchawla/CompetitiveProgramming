package assignment_3;

import java.util.Scanner;

public class ques2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a decimal number");
		int n = scn.nextInt();
		scn.close();
		int val = 0;
		int pow = 10;
		int counter = 0;
		while(n != 0){
			val = val + (n%8) * (int)(Math.pow(pow, counter));
			n = n/8;
			counter++;
		}
		System.out.println(val);

	}

}
