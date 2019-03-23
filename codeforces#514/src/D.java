
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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

    static class pair {
        double x;
        double y;

        pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        boolean ispos = false;
        boolean isneg = false;
        pair maxx = null;
        pair maxy = null;
        pair minx = null;
        pair miny = null;
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            if (y > 0) ispos = true;
            else isneg = true;
            arr[i] = new pair(x, y);
            if (maxx == null || x > maxx.x) maxx = new pair(x, y);
            if (maxy == null || y > maxy.y) maxy = new pair(x, y);
            if (minx == null || x < minx.x) minx = new pair(x, y);
            if (miny == null || y < miny.y) miny = new pair(x, y);
        }
        if (ispos && isneg) {
            System.out.println(-1);
            return;
        }
        double xpos = (minx.x + maxx.x) / 2.0;
        pair[] parr = {maxx, maxy, minx, miny};
        double ans = Double.MAX_VALUE;
        double lo = 0;
        double hi = 1e14;
        int count = 0;
        while (lo <= hi && count < 1000) {
            double mid = (lo + hi) / 2.0;
            if (check(mid, parr, xpos)) {
                ans = Math.min(ans, mid);
                hi = mid;
            } else {
                lo = mid;
            }
            count++;
        }
        System.out.println(BigDecimal.valueOf(ans));
    }

    private static boolean check(double mid, pair[] arr, double xpos) {
        for (pair p : arr) {
            if (isOk(p, mid, xpos) > 0) return false;
        }
        return true;
    }

    private static double isOk(pair p, double mid, double xpos) {
        return p.x * p.x + p.y * p.y - 2 * p.x * xpos - 2 * p.y * mid + xpos * xpos;
    }
}
