package codeAndCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class suresh {
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
		int n = fr.nextInt();
		int total = 0;
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			list.add(fr.nextInt());
		}

		for (int i = 0; i < list.size(); i++) {
			if (map.containsKey(list.get(i))) {
				map.put(list.get(i), map.get(list.get(i)) + 1);
			} else {
				map.put(list.get(i), 1);
			}
		}

		while (map.size() != 0) {
			int max = Integer.MIN_VALUE;
			int val = -1;
			for (Integer i : map.keySet()) {
				if (i * map.get(i) > max) {
					max = i * map.get(i);
					val = i;
				}
			}

			total += max;
			map.remove(val);
			map.remove(val + 1);
			map.remove(val - 1);

		}

		System.out.println(total);

	}

}
