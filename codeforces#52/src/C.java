import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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
        int n = fr.nextInt();
        int k = fr.nextInt();
        int N = 200009;
        int[] temp = new int[N];
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            temp[arr[i]]++;
        }
        long c = 0;
        long sum = 0;
        long ans = 0;
        for (long pos = N - 1; pos >= 0; pos--) {
            long val = sum - c * pos;
            if (k < val) {
                max = (int) (pos + 1);
                ans++;
                sum = (pos + 1) * (c - temp[(int) (pos + 1)]) + (pos + 1) * (temp[(int) (pos + 1)]);
            }
            if (pos == min) break;
            sum += pos * temp[(int) pos];
            c += temp[(int) pos];

        }
        if (max != min) ans++;
        System.out.println(ans);
    }
}
