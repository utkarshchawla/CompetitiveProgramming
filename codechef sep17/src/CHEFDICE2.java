import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFDICE2 {

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
			boolean flag = false;
			boolean flag2 = true;
			int n = fr.nextInt();
			int[] in = new int[n];
			for (int i = 0; i < in.length; i++) {
				in[i] = fr.nextInt();
				if (i > 0) {
					if (in[i] == in[i - 1]) {
						flag2 = false;
					}
				}

			}

			int[] arr = new int[6];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i + 1;
			}

			if (flag2) {
				while (nextPermutation(arr)) {
					if (isok(arr, in)) {
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			} else {
				System.out.println("-1");
			}

		}
	}

	private static boolean isok(int[] arr, int[] in) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1) {
				return false;
			}
		}

		for (int i = 0; i < in.length - 1; i++) {
			int v1 = in[i];
			int v2 = in[i + 1];

			if (arr[v1 - 1] == v2 || arr[v2 - 1] == v1) {
				return false;
			}
		}

		return true;
	}

	public static boolean nextPermutation(int[] array) {
		// Find longest non-increasing suffix
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;
		// Now i is the head index of the suffix

		// Are we at the last permutation already?
		if (i <= 0)
			return false;

		// Let array[i - 1] be the pivot
		// Find rightmost element that exceeds the pivot
		int j = array.length - 1;
		while (array[j] <= array[i - 1])
			j--;
		// Now the value array[j] will become the new pivot
		// Assertion: j >= i

		// Swap the pivot with j
		int temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		// Reverse the suffix
		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		// Successfully computed the next permutation
		return true;
	}

}
