package crux2sum2017;

import java.util.Scanner;

public class ass1ques7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("enter a number");
		int n = scn.nextInt();
		scn.close();
		int nsp = 1;
		int nst = n / 2 + 1;
		int r = 1;
		while (r <= n) {
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;

			}

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;

			}

			if (r <= n / 2) {
				nsp = nsp + 2;
				nst = nst - 1;
			} else {
				nsp = nsp - 2;
				nst = nst + 1;
			}

			r = r + 1;
			System.out.print("\n");
		}

	}

}
