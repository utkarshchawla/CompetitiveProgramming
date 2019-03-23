package assignment_3;

import java.util.Scanner;

public class ques10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter N1");
		int n1 = scn.nextInt();
		System.out.println("enter N2");
		int n2 = scn.nextInt();
		scn.close();
		arm(n1, n2);
		
		
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
			System.out.println(n);
		}
		return false;
	}
	
	public static void arm(int n1,int n2){
		while(n1 <= n2){
			armstrng(n1);
			n1 += 1;
		}
	}

}
