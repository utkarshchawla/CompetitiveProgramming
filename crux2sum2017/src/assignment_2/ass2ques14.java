package assignment_2;

import java.util.Scanner;

public class ass2ques14 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("enter a number");
		int x =  scn.nextInt();
		scn.close();
		int n = 2*x -1;
		int r = 1;
		int nsp = n / 2;
		int nsv = 1;
		int v1 =0;
		int v2 =0;
		int nst = 0;
		

		while (r <= n) {

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp +1;
			}
			int csv = 1;
			if( r <= n/2 + 1){
				v1 = r;
				while (csv <= nsv) {
					System.out.print(v1);
					v1 = v1 + 1;
					csv = csv + 1;
				}
				
			} else {
				v2 = 2*x -r;
				
				while (csv <= nsv) {
					System.out.print(v2);
					v2 = v2 + 1;
					csv = csv + 1;
				}
				
			}
			int m =0;
			if( r <= n/2 + 1){
				m = v1 - 2;
			} else {
				m = v2 - 2;
			}
			int cst = 1;
			while(cst <= nst){
				System.out.print(m);
				m =m -1;
				cst = cst + 1;
			}
			
			if(r <= n/2){
				nsp = nsp - 1;
				nsv = nsv + 1;
				nst = nst + 1;
				
			} else {
				nsp = nsp + 1;
				nsv = nsv - 1;
				nst = nst - 1;
			}

			r = r + 1;
			System.out.print("\n");
		}

	}

}
