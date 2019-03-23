package assignment_2;

import java.util.Scanner;

public class ass2ques9 {

	public static void main(String[] args) {
		Scanner scn = new  Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		int r = 0;
		
		while(r < n){
			int m = 1;
			int c = 0;
			while(c <= r){
				System.out.print(m);
				m = m*(r - c)/(c + 1);
				c++;
			}
			
			
			r++;
			System.out.print("\n");
		}
	}
}
