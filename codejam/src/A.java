import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class A {
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

    static void initializeDiffArray(long A[], long D[]) {

        int n = A.length;

        D[0] = A[0];
        D[n] = 0;
        for (int i = 1; i < n; i++)
            D[i] = A[i] - A[i - 1];
    }

    static void update(long D[], int l, int r, int x) {
        if (l >= 0 && l < D.length && r + 1 >= 0 && r + 1 < D.length) {
            D[l] += x;
            D[r + 1] -= x;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            int p = fr.nextInt();
            int q = fr.nextInt();
            long[] row = new long[q + 1];
            long[] drow = new long[q + 2];
            long[] dcol = new long[q + 2];
            long[] col = new long[q + 1];
            initializeDiffArray(row, drow);
            initializeDiffArray(col, dcol);
            for (int i = 0; i < p; i++) {
                String s = fr.nextLine();
                String[] arr = s.split(" ");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                if (arr[2].equals("N")) {
                    update(dcol, y + 1, q, 1);
                } else if (arr[2].equals("S")) {
                    update(dcol, 0, y - 1, 1);
                } else if (arr[2].equals("E")) {
                    update(drow, x + 1, q, 1);
                } else {
                    update(drow, 0, x - 1, 1);
                }
            }

            int xans = -1;
            long max = Long.MIN_VALUE;

            for (int i = 0; i < row.length; i++) {
                if (i == 0) {
                    row[i] = drow[i];
                } else {
                    row[i] = drow[i] + row[i - 1];
                }
                if (row[i] > max) {
                    xans = i;
                    max = row[i];
                }
            }
            int yans = -1;
            max = Long.MIN_VALUE;
            for (int i = 0; i < col.length; i++) {
                if (i == 0) {
                    col[i] = dcol[i];
                } else {
                    col[i] = dcol[i] + col[i - 1];
                }

                if (col[i] > max) {
                    yans = i;
                    max = col[i];
                }
            }
            System.out.println("Case #" + c + ": " + xans + " " + yans);

        }
    }
}
