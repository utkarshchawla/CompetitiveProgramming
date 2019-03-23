package assignment_3;

import java.util.Scanner;

public class ques14 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter the base");
		int b = scn.nextInt();
		scn.close();
		System.out.println(log(n, b));
	}
	public static int log(int n, int b){
		int counter = 1;
		while(n/b != 1){
			n = n/b;
			counter++;
		}
		return counter;
		
	}

}
