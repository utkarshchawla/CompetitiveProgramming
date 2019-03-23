package crux2sum2017;

import java.util.Scanner;

public class power_log {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("enter base");
		int b = scn.nextInt();
		System.out.println("enter power");
		int n = scn.nextInt();		
		scn.close();
		
		int r =1;
		int val =1;
		while(r <= n ){
			val = val*b;
			r = r + 1;
		}
        System.out.print(val);
	}

}
