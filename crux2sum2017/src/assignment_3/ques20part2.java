package assignment_3;

import java.util.Scanner;

public class ques20part2 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		input();
	}
	public static void input(){
		char c = scn.next().charAt(0);
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%'){
			int n1 = scn.nextInt();
			int n2 = scn.nextInt();
			System.out.println(calc(c, n1, n2));
			
		}else if(c == 'x' || c == 'X'){
			System.exit(0);
		}else {
			System.out.println("Invalid operation. Try again.");
		}	
		input();
	}
	
	public static int calc(char c,int n1,int n2){
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
	}
		return val;

}
}