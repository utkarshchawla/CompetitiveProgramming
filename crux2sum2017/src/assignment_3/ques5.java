package assignment_3;

import java.util.Scanner;

public class ques5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter min farhenite");
		int minf = scn.nextInt();
		System.out.println("enter max fahrenite");
		int maxf = scn.nextInt();
		System.out.println("enter step");
		int step = scn.nextInt();
		scn.close();
		
		while(minf <= maxf){
			int c = (int)((5.0/9) * (minf - 32));
			System.out.print(minf);
			System.out.println("  " + c);
			minf = minf + step;
		}
	}

}
