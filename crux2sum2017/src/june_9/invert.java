package june_9;

import java.util.Scanner;

public class invert {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		scn.close();
		int temp = n;
		int val = 0;
		int cntr = 0;
		while(temp != 0){
			cntr++;
			val += (cntr)*((int)Math.pow(10, (temp%10) -1));		
			temp = temp/10;
		}
		System.out.println(val);
		
		
	}

}
