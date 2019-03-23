package crux2sum2017;

import java.util.Scanner;

public class fibonnacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		scn.close();
		if(n == 0){
			System.out.println("0");
			return;
		}
		
		int a =0; 
		int b = 1;
		int counter = 2;
		int value = 0;
		while(counter <= n){
			value = a+b;
			a = b;
			b = value;
			counter++;
		}
		System.out.println(b);
       
	}

}
