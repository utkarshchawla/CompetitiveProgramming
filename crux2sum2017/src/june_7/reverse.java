package crux2sum2017;

import java.util.Scanner;

public class reverse {

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		scn.close();
		if(n <= 0 || n >= 1000000000 ){
		    return;
		}
		int v =0;
		while(n != 0){
			v = v*10 + n%10;
			n = n/10;		
		}
		System.out.print(v);

	}

}
