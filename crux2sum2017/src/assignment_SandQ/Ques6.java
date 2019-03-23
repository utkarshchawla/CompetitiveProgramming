package assignment_SandQ;

import java.util.Scanner;

import july_12.DynamicStack;
import july_12.stack;

public class Ques6 {

	public static void main(String[] args) throws Exception {
			Scanner scn = new Scanner(System.in);
			int a = scn.nextInt();
			int[] arr = new int[a];
			for(int i = 0 ; i < a; i++){
				arr[i] = scn.nextInt();
			}
					System.out.println();
	
			
			spanStock(arr);
	}

	public static void spanStock(int[] arr) throws Exception {

		stack s = new DynamicStack();
		for (int i = arr.length - 1; i >= 0; i--) {
			s.push(arr[i]);
		}

		int count = 1;
		int max = 0;
		int count2 = 1;
		System.out.println(s.top() + " => " + count);
		while (s.size() != 0) {
			count2++;
			int temp = s.pop();
			int temp2 = 0;
			if (s.size() > 0) {
				temp2 = s.top();
				if (temp2 > max) {
					max = temp2;
					System.out.println(s.top() + " => " + count2);
					continue;
				}
			} else {
				return;
			}
			if (temp <= temp2) {
				count++;
			} else {
				count = 1;
			}
			System.out.println(temp2 + " => " + count);

		}

	}

}
