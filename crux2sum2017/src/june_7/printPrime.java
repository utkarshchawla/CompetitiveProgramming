package june_7;

import java.util.Scanner;

public interface printPrime {
	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		System.out.println("enter n1");
		int n1 = scn.nextInt();
		System.out.println("enter n2(should be bigger than n1)");
		int n2 = scn.nextInt();
		scn.close();
		int x = 1;
		int r = 2;
		while(n1 < n2){
			r = 2;
			while(r < n1){
				
				if(n1%r == 0){
				    x = 0;
				    break;
				} else {
					x = 1;
					r += 1;
				}
			}
			
			if(x == 1){
				System.out.println(n1);
			}
			
			n1 += 1;
			
		}
		
		
		
		
	}
}
