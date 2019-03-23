package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RAINBOWA {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		int tc = fr.nextInt();
		while (tc > 0) {
			int n = fr.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				list.add(fr.nextInt());
				if (list.get(list.size() - 1) > max) {
					max = list.get(list.size() - 1);
				}
			}

			boolean c1 = case1(list);

			int maxidx = list.size() / 2;
			ArrayList<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < maxidx; i++) {
				list2.add(list.remove(list.size() - 1));
			}
			if (list.size() != list2.size()) {
				list.remove(list.size() - 1);
			}

			if (c1 && case2(list, list2)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			tc--;
		}
	}

	public static boolean case1(ArrayList<Integer> list) {

		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i + 1) != list.get(i)) {
				temp.add(list.get(i));
			}
		}

		temp.add(list.get(list.size() / 2));
		if (temp.size() != 7) {
			return false;
		}

		for (int i = 1; i <= 7; i++) {
			if (temp.get(i - 1) != i) {
				return false;
			}
		}

		return true;

	}

	public static boolean case2(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.size() != b.size()) {
			return false;
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != b.get(i)) {
				return false;
			}
		}

		return true;

	}
}
