import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {
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
		ArrayList<Integer> st = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st.add(fr.nextInt());
		}

		long sum = 0;
		ArrayList<ArrayList<Integer>> ml = sub(st);
		// HashMap<ArrayList<Integer>, Boolean> map = new HashMap<>();
		// for (int i = 0; i < ml.size(); i++) {
		// map.put(ml.get(i), true);
		// }
		//
		// ml = new ArrayList<>(map.keySet());
		for (int i = 0; i < ml.size(); i++) {
			if (ml.get(i).size() > 1) {
				int a = gcd(ml.get(i).get(0), ml.get(i).get(1), 2, ml.get(i));
				if (a > 1) {
					sum = (sum + a * ml.get(i).size()) % 1000000007;
				}
			} else if (ml.get(i).size() == 1) {
				if (ml.get(i).get(0) > 1) {
					sum += ml.get(i).get(0);
				}
			}
		}

		for (Integer i : st) {
			if (i > 1) {
				sum = (sum + i) % 1000000007;
			}
		}

		System.out.println(sum);
		// ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
		// System.out.println(sub(arr));

	}

	public static ArrayList<ArrayList<Integer>> sub(ArrayList<Integer> in) {
		if (in.size() == 0) {
			ArrayList<ArrayList<Integer>> br = new ArrayList<>();
			ArrayList<Integer> l = new ArrayList<>();
			br.add(l);
			return br;
		}

		int a = in.remove(in.size() - 1);
		ArrayList<ArrayList<Integer>> rr = sub(in);
		ArrayList<ArrayList<Integer>> mr = new ArrayList<>();
		for (int i = 0; i < rr.size(); i++) {
			mr.add(rr.get(i));

			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < rr.get(i).size(); j++) {
				tmp.add(rr.get(i).get(j));
			}

			tmp.add(a);
			mr.add(tmp);

		}

		return mr;

	}

	public static int gcd(int a, int b, int vidx, ArrayList<Integer> arr) {
		while (a % b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}

		if (vidx >= arr.size()) {
			return b;
		}

		return gcd(b, arr.get(vidx), vidx + 1, arr);
	}
}
