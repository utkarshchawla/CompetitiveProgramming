package assignment_3;

import java.util.Scanner;

public class ques3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a octal number");
		int n = scn.nextInt();
		scn.close();
		int val = 0;
		int pow = 8;
		int counter = 0;
		while(n != 0){
			val = val + (n%10) * (int)(Math.pow(pow, counter));
			n = n/10;
			counter++;
		}
		n = val;
		
		int val1 = 0;
		int pow1 = 10;
		int counter1 = 0;
		while(n != 0){
			val1 = val1 + (n%2) * (int)(Math.pow(pow1, counter1));
			n = n/2;
			counter1++;
		}
		System.out.println(val1);
	}

}
