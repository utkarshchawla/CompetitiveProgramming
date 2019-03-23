package assignment_9;

import java.util.Arrays;

public class assignment_9 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 4, 5 };
		// ques1(arr);
		System.out.println(ques2(arr));
	}

	public static void ques1(int[] arr) {

		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println(max + " " + min);
	}

	public static boolean ques2(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return true;
			}
		}
		return false;
	}

//	public static int[] ques3(int[] one, int[] two){
//		
//	}
}
