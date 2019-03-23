package assignment_8;

import java.util.ArrayList;
import java.util.Scanner;

public class assignment_8a {

	public static int count = 0;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = scn.nextInt();
		// }

		// int[] arr = { 1, 2, 3, 3, 4, 5 };
		// Scanner scn = new Scanner(System.in);
		// String s = scn.nextLine();
		// System.out.println(count);
		// ques4c(s, "");
		// ques1(s, "");
		// ArrayList<String> a = ques4List(s);
		// for (int i = 0; i < a.size(); i++) {
		// System.out.print(a.get(i) + " ");
		// }
		// System.out.println(ques6List(arr, 0, 0, 0));
		// ques6(arr, 0, "", "", 0, 0);
		ques4c("cab", "", "cab");

		// System.out.println(ques6List(arr, 0, 0, 0));
		// ques8(0, 250, true);
		// ques8(1, 1000);
	}

	public static ArrayList<String> ques1List(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = ques1List(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(rs + ch);
		}
		return mr;
	}

	public static void ques1(String ques, String ans) {
		if (ques.length() == 0) {
			count++;
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		ques1(roq, ans);
		ques1(roq, ans + ch);
		ques1(roq, ans + (int) ch);

	}

	public static ArrayList<String> ques3List(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = ques3List(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 0; i < getQuote(ch).length(); i++) {
			char ch2 = getQuote(ch).charAt(i);
			for (String rs : rr) {
				mr.add(ch2 + rs);

			}
		}
		return mr;
	}

	public static void ques3(String ques, String ans) {
		if (ques.length() == 0) {
			count++;
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i < getQuote(ch).length(); i++) {
			char ch2 = getQuote(ch).charAt(i);
			ques3(roq, ans + ch2);
		}

	}

	public static ArrayList<String> ques4List(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = ques4List(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 0; i <= ros.length(); i++) {
			for (String rs : rr) {
				mr.add(rs.substring(0, i) + ch + rs.substring(i));
			}
		}
		return mr;
	}

	public static void ques4c(String ques, String ans, String co) {
		if (ques.length() == 0) {
			if (ans.compareTo(co) < 0) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			ques4c(roq, ch + ans, co);
		}

		// char ch = ques.charAt(0);
		// String roq = ques.substring(1);
		//
		// for (int i = 0; i <= ans.length(); i++) {
		// ques4c(roq, ans.substring(0, i) + ch + ans.substring(i));
		// }

	}

	public static void ques5b(int n, char r1, char r2, char r3) {
		if (n == 1) {
			count++;
			System.out.println(n + " from " + r1 + " to " + r3);
			return;
		}
		ques5b(n - 1, r1, r3, r2);
		System.out.println(n + " from " + r1 + " to " + r3);
		ques5b(n - 1, r2, r1, r3);

	}

	public static ArrayList<String> ques6List(int[] arr, int vidx, int s1, int s2) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();
			if (s1 == s2) {
				br.add("");
			}
			return br;
		}

		ArrayList<String> rr1 = ques6List(arr, vidx + 1, s1 + arr[vidx], s2);
		ArrayList<String> rr2 = ques6List(arr, vidx + 1, s1, s2 + arr[vidx]);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr1) {
			mr.add(rs + arr[vidx]);
		}
		// mr.add(" and ");

		for (String rs : rr2) {
			mr.add(rs + arr[vidx]);
		}
		return mr;
	}

	public static void ques6(int[] arr, int vidx, String as1, String as2, int s1, int s2) {
		if (vidx == arr.length) {
			if (s1 == s2) {
				count++;
				System.out.print(as1 + ", and , " + as2 + " ");

			}
			return;
		}

		ques6(arr, vidx + 1, as1 + arr[vidx], as2, s1 + arr[vidx], s2);
		ques6(arr, vidx + 1, as1, as2 + arr[vidx], s1, s2 + arr[vidx]);
	}

	public static ArrayList<String> ques7List(int[] arr, int vidx, int target) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();
			if (target == 0) {
				br.add("");
			}

			return br;
		}
		ArrayList<String> rr1 = ques7List(arr, vidx + 1, target);
		ArrayList<String> rr2 = ques7List(arr, vidx + 1, target - arr[vidx]);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr1) {
			mr.add(rs);
		}
		for (String rs : rr2) {
			mr.add(rs + arr[vidx]);
		}

		return mr;

	}

	public static void ques7(int[] arr, int vidx, int target, String s) {
		if (vidx == arr.length) {
			if (target == 0) {
				System.out.println(s);
			}
			return;
		}

		ques7(arr, vidx + 1, target, s);
		ques7(arr, vidx + 1, target - arr[vidx], s + arr[vidx]);

	}

	public static void ques8(int cur, int end) {
		if (cur >= end) {
			return;
		}

		if (cur % 10 == 9) {
			System.out.println(cur);
			return;
		}

		// System.out.println(cur);
		// ques8(cur * 10, end);
		// for (int i = 0; i <= 9; i++) {
		// if (cur % 10 == 9) {
		// System.out.println(cur);
		// return;
		// } else {
		// ques8(cur + i, end);
		// }
		// }
		ques8(cur * 10, end);
		ques8(cur + 1, end);

	}

	public static String getQuote(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jkl";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yx";
		} else {
			return ".;_";
		}
	}

}
