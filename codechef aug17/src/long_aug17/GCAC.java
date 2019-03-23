package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCAC {

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
		FastReader scn = new FastReader();
		int tc = scn.nextInt();
		while (tc > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			long[] minSalary = new long[n];
			long[] offeredSalary = new long[m];
			int[] maxJobOffers = new int[m];
			int[] unhired = new int[m];
			int[][] qual = new int[n][m];

			for (int i = 0; i < n; i++) {
				minSalary[i] = scn.nextInt();
			}

			for (int i = 0; i < m; i++) {
				offeredSalary[i] = scn.nextInt();
				maxJobOffers[i] = scn.nextInt();
			}

			for (int i = 0; i < m; i++) {
				unhired[i] = maxJobOffers[i];
			}

			for (int i = 0; i < n; i++) {
				String s = scn.next();
				for (int j = 0; j < m; j++) {
					qual[i][j] = s.charAt(j) - 48;
				}
			}

			long nOfCandidates = 0;
			long totalSal = 0;
			for (int i = 0; i < n; i++) {
				long max = 0;
				int temp = 0;
				for (int j = 0; j < m; j++) {
					if (qual[i][j] == 1 && maxJobOffers[j] > 0) {
						if (offeredSalary[j] > max && offeredSalary[j] >= minSalary[i]) {
							maxJobOffers[j]--;
							if (max == 0) {
								nOfCandidates++;
								totalSal += offeredSalary[j];
							} else {
								maxJobOffers[temp]++;
								totalSal = totalSal + offeredSalary[j] - max;
							}
							temp = j;
							max = offeredSalary[j];
						}
					}
				}
			}

			long cuh = 0;
			for (int i = 0; i < m; i++) {
				if (unhired[i] == maxJobOffers[i]) {
					cuh++;
				}
			}

			System.out.println(nOfCandidates + " " + totalSal + " " + cuh);
			tc--;
		}

	}

}
