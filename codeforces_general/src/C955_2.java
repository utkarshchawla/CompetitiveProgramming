import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C955_2 {
    private static ArrayList<Long> list = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        precal();
        int q = fr.nextInt();
        while (q-- > 0) {
            long l = fr.nextLong();
            long r = fr.nextLong();
            int hi = jSmaller(r);
            int lo = jLarger(l);
            int ans = hi - lo + 1;
            if (lo == -1 || hi == -1) ans = 0;
//            if (ans < 0) ans = 0;
//            ans += Math.floor(Math.sqrt(r));
//            ans -= Math.floor(Math.sqrt(l - 1));
            ans += (root(r) - root(l - 1));
            fw.println(ans);
        }
        fw.close();
    }

    private static void precal() {
        long u = (long) 1e18;
        ArrayList<Long> temp = new ArrayList<>();
        temp.add(1L);
        for (long i = 2; i <= 1e6; i++) {
            for (long j = i * i * i; j <= u; j *= i) {
                temp.add(j);
                if (j > u / i) break;
            }
        }

        temp.sort(null);
        ArrayList<Long> t2 = new ArrayList<>();
        for (long i : temp) {
            long sqr = (long) Math.sqrt(i);
            if (sqr * sqr == i) continue;
            t2.add(i);
        }
        for (int i = 0; i < t2.size() - 1; i++) {
            if (t2.get(i).equals(t2.get(i + 1))) continue;
            list.add(t2.get(i));
        }
        list.add(t2.get(t2.size() - 1));

    }

    private static int jLarger(long val) {
        int lo = 0;
        int hi = list.size() - 1;
        int idx = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > val) {
                hi = mid - 1;
                idx = mid;
            } else if (list.get(mid) < val) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return idx;
    }

    private static int jSmaller(long val) {
        int lo = 0;
        int hi = list.size() - 1;
        int idx = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > val) {
                hi = mid - 1;
            } else if (list.get(mid) < val) {
                lo = mid + 1;
                idx = mid;
            } else {
                return mid;
            }
        }

        return idx;
    }

    private static long root(long x) {
        long l = 0, r = (long) 1e9 + 1L;
        while (l < r - 1) {
            long m = (l + r) / 2;
            if (m * m > x)
                r = m;
            else
                l = m;
        }
        return l;
    }

}



