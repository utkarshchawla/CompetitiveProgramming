package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MINPERM {

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
			int n = fr.nextInt();
			int[] arr = new int[n];

			for (int i = 1; i <= n; i++) {
				arr[i - 1] = i;
			}

			while (!checker(arr)) {
				nextPermutation(arr);
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.println();
		}
	}

	public static boolean nextPermutation(int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;
		if (i <= 0)
			return false;

		int j = array.length - 1;
		while (array[j] <= array[i - 1])
			j--;

		int temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static boolean checker(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1) {
				return false;
			}
		}

		return true;
	}

}
