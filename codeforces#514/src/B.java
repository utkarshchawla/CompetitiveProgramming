import java.io.*;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[][] arr = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = fr.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '#') {
                    arr[i][j] = 1;
                    count++;
                }
            }
        }

        int[] r = {1, 0, -1, 0, -1, 1, 1, -1};
        int[] c = {0, 1, 0, -1, -1, 1, -1, 1};
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                boolean flag = true;
                for (int k = 0; k < 8; k++) {
                    if (arr[i + r[k]][j + c[k]] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < 8; k++) {
                        if (arr[i + r[k]][j + c[k]] == 1) {
                            arr[i + r[k]][j + c[k]] = 2;
                            count--;
                        }
                    }
                }
            }
        }

        if (count == 0) System.out.println("YES");
        else System.out.println("NO");

    }
}
