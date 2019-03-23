package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CHEFFA {
	public static int count = 0;
	public static final int M = 1000000007;

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
		HashMap<ArrayList<Integer>, Boolean> map = new HashMap<>();
		while (tc > 0) {
			int n = fr.nextInt();
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				list.add(fr.nextInt());
			}

			helper(list, map);
			System.out.println(count + 1);
			count = 0;
			tc--;
		}
	}

	public static void helper(ArrayList<Integer> list, HashMap<ArrayList<Integer>, Boolean> map) {

		boolean flag = false;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > 0 && list.get(i + 1) > 0) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			return;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > 0 && list.get(i + 1) > 0 && i + 2 < list.size()) {
				ArrayList<Integer> temp = new ArrayList<>(list);
				temp.set(i, temp.get(i) - 1);
				temp.set(i + 1, temp.get(i + 1) - 1);
				temp.set(i + 2, temp.get(i + 2) + 1);
				if (!map.containsKey(temp)) {
					map.put(temp, true);
					count = (count + 1) % M;
					helper(temp, map);
				}

			} else if (list.get(i) > 0 && list.get(i + 1) > 0 && i + 2 >= list.size()) {
				ArrayList<Integer> temp = new ArrayList<>(list);
				temp.set(i, temp.get(i) - 1);
				temp.set(i + 1, temp.get(i + 1) - 1);
				temp.add(1);
				if (!map.containsKey(temp)) {
					map.put(temp, true);
					count = (count + 1) % M;
					helper(temp, map);
				}
			}
		}
	}
}
