package assignment_5;

import june_19.stringops;

public class assignment_5 {

	public static void main(String[] args) {

		String s = "ababaaabbaa";
//		System.out.println(ques8(s));
		ques6("abc");

	}

	public static boolean ques1(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int ques2(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (ques1(s.substring(i, j))) {
					System.out.println(s.substring(i, j));
					count++;
				}
			}
		}
		return count;
	}

	public static String ques3(String s) {
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 'a' && s.charAt(i) < 'z') {
				ch = (char) (s.charAt(i) - 'a' + 'A');

			} else {
				ch = (char) (s.charAt(i) - 'A' + 'a');
			}
			sb.append(ch);
		}
		return sb.toString();

	}

	public static String ques4(String s) {
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				ch = (char) (s.charAt(i) - 1);
			} else {
				ch = (char) (s.charAt(i) + 1);
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	public static String ques5(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			int count = 0;
			count = s.charAt(i + 1) - s.charAt(i);
			sb.append(s.charAt(i));
			sb.append(count);
		}
		sb.append(s.charAt(s.length() - 1));

		return sb.toString();
	}

	public static char ques8(String s) {
		int temp = 0;
		char ch = 'a';
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					count++;
				}
			}
			if (count > temp) {
				temp = count;
				ch = s.charAt(i);
			}
		}
		return ch;
	}

	public static String ques9(String s) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				i++;
			}
		}
		return sb.toString();
	}

	public static String ques10(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			sb.append(s.charAt(i));
			while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			if (count + 1 > 1) {
				sb.append(count + 1);
			}

		}
		return sb.toString();
	}

	public static void ques6(String s) {
		int n = (int) (Math.pow(2, s.length()));
		int counter = 0;

		while (counter < n) {
			int temp = counter;
			for (int i = 0; i < s.length() && temp != 0; i++) {
				int x = temp % 2;
				if (x == 1) {
					System.out.print(s.charAt(i));
				}
				temp = temp / 2;
			}
			System.out.println();

			counter++;
		}

	}
}
