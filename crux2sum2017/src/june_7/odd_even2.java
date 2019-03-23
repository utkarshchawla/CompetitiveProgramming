package crux2sum2017;

import java.util.Scanner;

public class odd_even2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sumOdd = 0;
		int sumEven = 0;
		while(n != 0){
			sumOdd += n%10;
			n = n/10;
			sumEven += n%10;
			n = n/10;
		}
		System.out.println(sumOdd);
		System.out.println(sumEven);


	}

}
