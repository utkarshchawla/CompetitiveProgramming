package assignment_3;

import java.io.*;;

public class ques18 {

	public static void main(String[] args) throws IOException {
		Reader reader = new InputStreamReader(System.in);
		int c = reader.read();
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
