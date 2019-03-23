package crux2sum2017;

import java.util.Scanner;

public class GCD_LCM {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("enter n1");
		int n1 = scn.nextInt();
		System.out.println("enter n2");
		int n2 = scn.nextInt();		
		scn.close();
		int r =0;
		int a = n1;
		int b =n2;
		while(n1%n2 != 0){
			r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		System.out.println("GCD is " + r);
		System.out.println("LCM is " + a*b/r);

		

	}

}
