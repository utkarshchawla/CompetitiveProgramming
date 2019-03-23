package assignment_2;

import java.util.Scanner;

public class ass2ques13 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		scn.close();
		int r = 1;
		
		while(r <= n){
			int nsp = n - r;
			int csp = 1;
			while(csp <= nsp){
				System.out.print("\t");
				csp++;
			}
			int nst = r;
			int cst = 1;
			int val = r;
			while(cst <= nst){
				System.out.print(val + "\t");
				val++;
				cst++;
			}
			
			val -= 2;
			int m = r-1;
			int x = 1;
			while(x <= m){
				System.out.print(val + "\t");
				x++;
				val--;
			}
			
			r++;
			System.out.print("\n");
		}

	}

}
