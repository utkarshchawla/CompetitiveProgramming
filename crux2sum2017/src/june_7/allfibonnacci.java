package crux2sum2017;

import java.util.Scanner;

public class allfibonnacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		scn.close();
		int a = 0;
		int b = 1;
		int value = 1;
		System.out.println(a);
		while(value <= n){
			System.out.println(value);
			value = a+b;
			a =b;
			b = value;
			
			
		}
		

	}

}
