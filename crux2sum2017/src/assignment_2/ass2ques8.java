package assignment_2;

import java.util.Scanner;

public class ass2ques8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		int r = 1;
		int nst = 1;

		while (r <= n) {

			int val = r;
			int nz = r - 2;
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
			}
			int cz = 1;
			while (cz <= nz) {
				System.out.print("0");
				cz++;
			}
			if (r > 1) {
				cst = 1;
				while (cst <= nst) {
					System.out.print(val);
					cst++;
				}

			}
			r++;
			System.out.print("\n");
		}

	}

}
