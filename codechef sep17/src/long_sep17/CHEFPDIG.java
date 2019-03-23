package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CHEFPDIG {

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
		int t = fr.nextInt();
		while (t-- > 0) {
			String s = fr.nextLine();
			HashMap<Integer, Integer> map = new HashMap<>(10);
			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i) - 48;
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}

			}

			ArrayList<Character> list = new ArrayList<>();
			for (int i = 65; i <= 90; i++) {
				int temp = i;
				int a = temp % 10;
				temp /= 10;
				int b = temp % 10;

				if (a == b) {
					if (map.containsKey(a) && map.get(a) >= 2) {
						list.add((char) i);
					}
				} else {
					if (map.containsKey(a) && map.containsKey(b)) {
						list.add((char) i);
					}
				}
			}

			for (Character c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
