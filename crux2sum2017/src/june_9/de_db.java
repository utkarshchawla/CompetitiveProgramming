package june_9;

import java.util.Scanner;

public class de_db {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the destination base");
		int b = scn.nextInt();
		scn.close();
		
		int val = 0;
		int cntr = 0;
		int pow = 10;
		while(n != 0){
			val = val + n%b * ((int)(Math.pow(pow, cntr)));
			n = n/b;
			cntr++;
		}
		System.out.println(val);
	
		

	}

}
