package june_9;

import java.util.Scanner;

public class nu_sb_db {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the starting base");
		int b = scn.nextInt();
		System.out.println("enter the destination base");
		int d = scn.nextInt();
		scn.close();
		int val1 = 0;
		int cntr1 = 0;
		int pow1 = b;
		while(n != 0){
			val1 = val1 + n%10 * ((int)(Math.pow(pow1, cntr1)));
			n = n/10;
			cntr1++;
		}
		
		int n1 = val1;
		int val = 0;
		int cntr = 0;
		int pow = 10;
		while(n1 != 0){
			val = val + n1%d * ((int)(Math.pow(pow, cntr)));
			n1 = n1/d;
			cntr++;
		}
		System.out.println(val);

	}

}
