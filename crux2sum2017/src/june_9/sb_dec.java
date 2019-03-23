package june_9;

import java.util.Scanner;

public class sb_dec {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the starting base");
		int b = scn.nextInt();
		scn.close();
		int val = 0;
		int cntr = 0;
		int pow = b;
		while(n != 0){
			val = val + n%10 * ((int)(Math.pow(pow, cntr)));
			n = n/10;
			cntr++;
		}
		System.out.println(val);

	}

}
