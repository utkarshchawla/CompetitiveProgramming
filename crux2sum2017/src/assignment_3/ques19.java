package assignment_3;

import java.util.Scanner;

public class ques19 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] s = new int[n];
		for(int i = 0; i < n; i++){
			s[i] = scn.nextInt();
		}
		
		System.out.println(split(s));
	}
	
	public static boolean split(int[] arr){

		int i = 0;
			while(i < (arr.length -1)  && arr[i + 1] < arr[i]) {
				i++;
				
			}
			i++;
			if(i == arr.length - 1){
				return true;
			}
			while(i < (arr.length - 1)  && arr[i + 1] > arr[i]){
				i++;
				if( i == (arr.length - 1)){
					return true;
				}
				

			}
return false;
}
}