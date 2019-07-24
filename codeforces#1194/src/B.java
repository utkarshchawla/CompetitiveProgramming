import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
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

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static class pair {
        int h;
        int v;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int q = fr.nextInt();
        while (q-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s = fr.nextLine();
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == '*') arr[i][j] = 1;
                }
            }

            pair[][] one = new pair[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    pair mp = new pair();
                    if (j - 1 >= 0) mp.h = one[i][j - 1].h;
                    if (i - 1 >= 0) mp.v = one[i - 1][j].v;
                    if (arr[i][j] == 0) {
                        mp.h++;
                        mp.v++;
                    }
                    one[i][j] = mp;
                }

            pair[][] two = new pair[n][m];
            for (int i = n - 1; i >= 0; i--)
                for (int j = m - 1; j >= 0; j--) {
                    pair mp = new pair();
                    if (j + 1 < m) mp.h = two[i][j + 1].h;
                    if (i + 1 < n) mp.v = two[i + 1][j].v;
                    if (arr[i][j] == 0) {
                        mp.h++;
                        mp.v++;
                    }

                    two[i][j] = mp;

                }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    int val = one[i][j].h + one[i][j].v + two[i][j].h + two[i][j].v;
                    if (arr[i][j] == 0) val -= 3;
                    ans = Math.min(ans, val);
                }

            System.out.println(ans);
        }
    }
}