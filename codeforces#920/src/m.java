import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class m {
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
        int[] wts = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = i + 1;
            val[i] = fr.nextInt();
        }
        int strg[][] = new int[n + 1][n + 1];

        int ans = knapsackdp(wts, val, n, 0, strg);
        System.out.println(ans);
    }

    public static int knapsackdp(int[] wts, int[] val, int cap, int vidx, int[][] strg) {
        if (vidx == wts.length) {
            return 0;
        }
        if (strg[cap][vidx] != 0) {
            return strg[cap][vidx];
        }

        int v1 = 0, v2 = 0;
        v1 = knapsackdp(wts, val, cap, vidx + 1, strg);
        if (cap >= wts[vidx]) {
            v2 = val[vidx] + knapsackdp(wts, val, cap - wts[vidx], vidx + 1, strg);
        }

        int rv = Math.max(v1, v2);
        strg[cap][vidx] = rv;
        return rv;
    }
}
