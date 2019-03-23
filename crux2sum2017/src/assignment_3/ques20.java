package assignment_3;

import java.util.Scanner;

public class ques20 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		 char c = scn.next().charAt(0);		
		if(check(c)){
			input(c);
		}else{
			main(null);
		}	
	}
   public static boolean check(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%'){
			return true;
		}else if(c == 'x' || c == 'X'){
			System.exit(0);
		}
		return false;
		
	}
	
	public static void cal(char c, int n1, int n2){
		int val = 0;
		switch(c){
		case '+' :
			val = n1 + n2;
			break;
		case '-' :
			val = n1 - n2;
			break;
		case '*' :
			val = n1 * n2;
			break;
		case '/' :
			val = n1 / n2;
			break;
		case'%' :
			val = n1%n2;
			break;
		default :
			System.out.println("invalid operation");
		}
		
	System.out.println(val);
	main(null);
	}

	public static int input(char c){
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		cal(c, n1, n2);
		return n1 & n2;
		
	}
}
