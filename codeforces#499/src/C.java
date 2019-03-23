import javax.sound.midi.Soundbank;
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
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        double[] lift = new double[n];
        double[] land = new double[n];
        for (int i = 0; i < n; i++) {
            lift[i] = fr.nextDouble();
            if (lift[i] <= 1) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            land[i] = fr.nextDouble();
            if (land[i] <= 1) {
                System.out.println(-1);
                return;
            }
        }
        double lo = 0;
        double hi = 1e9;
        double ans = Double.MAX_VALUE;
        while (lo <= hi) {
            double mid = (hi + lo) / 2;
            boolean isok = helper(m, mid, lift, land);
            if (isok) {
                ans = Math.min(ans, mid);
                hi = mid - 0.0000001;
            } else {
                lo = mid + 0.0000001;
            }
        }
        if (ans < Double.MAX_VALUE) System.out.printf("%.10f", ans);
        else System.out.println(-1);
    }

    private static boolean helper(double w, double f, double[] lift, double[] land) {
        for (int i = 0; i < lift.length; i++) {
            int idxland = (i + 1) % lift.length;
            f -= (w + f) / lift[i];
            if (f < 0) return false;
            f -= (w + f) / land[idxland];
            if (f < 0) return false;
        }
        return true;
    }
}
