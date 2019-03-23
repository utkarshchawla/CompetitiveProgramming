package june_9;

import java.util.Scanner;

public class rotate {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int n = scn.nextInt();
		System.out.println("enter rotation factor");
		int x = scn.nextInt();
		scn.close();
		int v = n;
		int counter = 0;
		while(v != 0){
			v = v/10;
			counter++;
		}
		if(x < 0){
			x = x + counter;
		}
		int rot = x%counter;
		int a = (int) (Math.pow(10, rot));
		int rem = n%a;
		n = n/a;
		rem = rem*(int) (Math.pow(10, counter - rot));
		n = rem + n;
		System.out.println(n);
	}

}
