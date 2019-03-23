package assignment_3;

import java.util.Scanner;

public class ques17 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number");
		int n = scn.nextInt();
		System.out.println("enter p");
		int p = scn.nextInt();
		scn.close();
		System.out.println(sqrrt(n,p));
	}
	
	public static double sqrrt(int n,int p){
		double s = (Math.sqrt(n));
		s = s * Math.pow(10, p);
        s = (int)s;
        s = s/Math.pow(10, p);
		return s;
	}

	}

