package assignment_3;

import java.util.Scanner;

public class ques15 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter N1");
		int n1 = scn.nextInt();
		System.out.println("enter N2");
		int n2 = scn.nextInt();
		scn.close();
		multple(n1, n2);
	}

	public static void multple(int n1, int n2) {
		int n = 0;
		int counter = 1;
		while (counter <= n1) {
			int x = 3 * n + 2;
			if ((3 * n + 2) % n2 != 0) {
				System.out.println(x);
				counter++;
			}

			n++;

		}

	}

}
