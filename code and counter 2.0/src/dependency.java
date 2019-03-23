package codeAndCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class dependency {

	static class heapmover {
		String ans = "";
	}

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
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		int n = fr.nextInt();
		int m = fr.nextInt();

		for (int i = 0; i < m; i++) {
			String s = fr.next();
			String d = fr.next();
			set.add(d);
			set.add(s);
			if (map.containsKey(s)) {
				map.get(s).add(d);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(d);
				map.put(s, list);
			}
		}

		ArrayList<String> temp = new ArrayList<>(set);
		temp.sort(null);
		heapmover mover = new heapmover();
		solver(temp.get(0), temp, map, new HashSet<>(), mover);
		StringBuilder sb = new StringBuilder(mover.ans);
		sb.delete(sb.length() - 3, sb.length());
		System.out.println(sb);
	}

	public static void solver(String str, ArrayList<String> temp, HashMap<String, ArrayList<String>> map,
			HashSet<String> done, heapmover mover) {
		if (temp.size() == 0) {
			return;
		}

		if (!map.containsKey(str)) {
			// System.out.print(str + " -> ");
			mover.ans += str + " -> ";
			done.add(str);
			temp.remove(str);
			if (temp.size() != 0) {
				solver(temp.get(0), temp, map, done, mover);
			}
		} else {
			for (int i = 0; i < map.get(str).size(); i++) {
				String ar = map.get(str).get(i);
				if (done.contains(ar)) {
					map.get(str).remove(ar);
					i--;
				}
			}
			if (map.get(str).size() == 0) {
				// System.out.print(str + " -> ");
				mover.ans += str + " -> ";
				done.add(str);
				temp.remove(str);
				if (temp.size() != 0) {
					solver(temp.get(0), temp, map, done, mover);
				}
			} else {

				for (int i = 0; i < map.get(str).size(); i++) {
					String ar = map.get(str).get(i);
					solver(ar, temp, map, done, mover);
				}
			}
		}

	}

}
