package assignment_2;

import java.util.Scanner;

public class ass2ques7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		int r = 1;
		int val = 1;
		while(r <= n){
			int c = 1;
			while(c <= r){
				System.out.print(val);
				c++;
				val++;
			}
			r++;
			System.out.print("\n");
		}
		

	}

}
