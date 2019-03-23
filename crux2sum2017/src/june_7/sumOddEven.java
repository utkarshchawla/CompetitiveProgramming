package crux2sum2017;

import java.util.Scanner;

public class sumOddEven {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sumOdd = 0;
		int sumEven = 0;
		int v = n;
		int x = 0;
		int m = n;
		
	    int counter = 0;
	    while(v != 0){
	    	counter++;
	    	v = v/10;
	    }	
	    if(counter%2 == 0){
	    	x = 0;
	    } else {
	    	x = 1;
	    }
	    
	    while(n != 0){
	    	sumOdd += n%10;
	    	n = n/10;
	    	sumEven += n%10;
	    	n = n/10;
	    }
	    
	    if(counter == 1){
	    	System.out.println(m);
	    	System.out.println("0");
	    }else {
	    	 if(x == 0){
	 	    	System.out.println(sumOdd);
	 	    	System.out.println(sumEven);

	 	    } else {
	 	    	System.out.println(sumEven);
	 	    	System.out.println(sumOdd);
	 	    	
	 	    }
	    }
	   
	    
		

	}

}
