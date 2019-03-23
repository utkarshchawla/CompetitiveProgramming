package assignment_3;

import java.util.Scanner;

public class ques12 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter N1");
		int n1 = scn.nextInt();
		System.out.println("enter N2");
		int n2 = scn.nextInt();
		scn.close();
		System.out.println(lcm(n1, n2));
	}
	public static int lcm(int n1,int n2){
		int temp1 = n1;
		int temp2 = n2;
		while(n1%n2 != 0){
			int r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		return (temp1 * temp2)/n2;
	}
}
