package assignment_3;

import java.util.Scanner;

public class ques9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		scn.close();
		System.out.println(armstrng(n));
	}
	
	public static boolean armstrng(int n){
		int temp = n;
		int val = 0;
		int temp1 = n;
		int cntr = 0;
		while(temp1 != 0){
			cntr++;
			temp1 = temp1/10;
		}
		while(temp != 0){
			val += (int)(Math.pow(temp%10,cntr));
			temp = temp/10;
		}
		if(val == n){
			return true;
		}
		return false;
	} 

}
