package crux2sum2017;

import java.util.Scanner;

public class ass1ques6{

	public static void main(String[] args) {
		/*
		 * int p = 1000; int r = 10; int t =2;
		 * 
		 * int si = ( p * r * t)/100;
		 * 
		 * System.out.println("simple interest is " + si);
		 */

		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		scn.close();
		int r = 1;
		int nsp = n / 2;
		int nst = 1;
		while (r <= n) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			if (r <= n / 2) {
				nsp = nsp - 1;
				nst = nst + 2;
			} else {
				nsp = nsp + 1;
				nst = nst - 2;
			}

			r = r + 1;
			System.out.print("\n");
		}
	}

}
