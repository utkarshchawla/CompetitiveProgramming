package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PALINGAM2 {

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
			String s = fr.next();
			String t = fr.next();
			int[] arrs = new int[26];
			int[] arrt = new int[26];
			boolean re = false;
			for (int i = 0; i < s.length(); i++) {
				arrs[s.charAt(i) - 97]++;
			}

			for (int i = 0; i < t.length(); i++) {
				arrt[t.charAt(i) - 97]++;
			}

			for (int i = 0; i < arrs.length; i++) {
				if (arrs[i] > 1 && arrt[i] == 0) {
					re = true;
				}
				
				if(arrs[i] > 0 && arrt[i] == 0){
					boolean flag = false;
					for(int j = 0; j < arrt.length; j++){
						if(arrt[j] > 0 && arrs[j] == 0){
							flag = true;
						}
					}
					if(!flag){
						re = true;
					}
					
				}
			}
			
			if(re){
				System.out.println("A");
			} else {
				System.out.println("B");
			}

			tc--;
		}
	}

}
