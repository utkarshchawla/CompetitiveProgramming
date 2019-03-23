package assignment_3;


import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char c = scn.nextLine().charAt(0);
		String result = chr(c);
		System.out.println(result);
	}
	public static String chr(int c){
		String val = "Invalid";
		if( Character.isLowerCase(c)){
			val = "lowercase";
			return val;
			
		}else if(Character.isUpperCase(c)){
			val = "UPPERCASE";
			return val;
		}else{
			return val;
		}
	}

}
