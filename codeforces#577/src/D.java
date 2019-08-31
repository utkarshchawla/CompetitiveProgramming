import java.io.*;
import java.math.BigInteger;
import java.util.*;

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();
        int q = fr.nextInt();
        int[] left = new int[n + 1];
        Arrays.fill(left, Integer.MAX_VALUE);
        int[] right = new int[n + 1];
        Arrays.fill(right, Integer.MIN_VALUE);
        while (k-- > 0) {
            int tr = fr.nextInt();
            int tc = fr.nextInt();
            left[tr] = Math.min(left[tr], tc);
            right[tr] = Math.max(right[tr], tc);
        }
        ArrayList<Integer> safe = new ArrayList<>();
        for (int i = 0; i < q; i++) safe.add(fr.nextInt());
        safe.sort(null);

        int[] col = {1, 1, 1, 1};
        long[] dis = {0, 0, 0, 0};
        int idx = n;
        while (right[idx] == Integer.MIN_VALUE) idx--;
        int extra = 0;
        if (right[1] == Integer.MIN_VALUE && safe.get(0) != 1) {
            extra += safe.get(0) - 1;
            Arrays.fill(col, safe.get(0));
        }
        for (int i = 1; i <= idx; i++) {
            if (right[i] == Integer.MIN_VALUE || left[i] == Integer.MAX_VALUE) continue;
            int l = Collections.binarySearch(safe, left[i]);
            int ll = l;
            int lr = l;
            if (l < 0) {
                l = -(l + 1);
                if (l - 1 >= 0) ll = l - 1;
                else ll = l;
                if (l == safe.size()) lr = l - 1;
                else lr = l;
            }


            int r = Collections.binarySearch(safe, right[i]);
            int rl = r;
            int rr = r;
            if (r < 0) {
                r = -(r + 1);
                if (r - 1 >= 0) rl = r - 1;
                else rl = r;
                if (r == safe.size()) rr = r - 1;
                else rr = r;
            }

            ll = safe.get(ll);
            lr = safe.get(lr);
            rl = safe.get(rl);
            rr = safe.get(rr);
            if (i == idx) {
                ll = lr = left[i];
                rl = rr = right[i];
            }

            long[] ta = new long[4];
            Arrays.fill(ta, Long.MAX_VALUE);
            for (int j = 0; j < 4; j++) {
                ta[0] = Math.min(ta[0], dis[j] + getdist(ll, col[j], right[i], left[i], "ll"));
                ta[1] = Math.min(ta[1], dis[j] + getdist(lr, col[j], right[i], left[i], "lr"));
                ta[2] = Math.min(ta[2], dis[j] + getdist(rl, col[j], right[i], left[i], "rl"));
                ta[3] = Math.min(ta[3], dis[j] + getdist(rr, col[j], right[i], left[i], "rr"));
            }
            for (int j = 0; j < 4; j++) dis[j] = ta[j];
            col[0] = ll;
            col[1] = lr;
            col[2] = rl;
            col[3] = rr;
        }

        Arrays.sort(dis);

        System.out.println(dis[0] + idx - 1 + extra);


    }

    private static int getdist(int e, int s, int r, int l, String str) {
        if (str.equals("ll")) return Math.abs(r - s) + Math.abs(r - l) + Math.abs(l - e);
        else if (str.equals("lr")) return Math.abs(r - s) + Math.abs(r - l) + Math.abs(e - l);
        else if (str.equals("rl")) return Math.abs(s - l) + Math.abs(r - l) + Math.abs(r - e);
        else return Math.abs(s - l) + Math.abs(r - l) + Math.abs(e - r);
    }

}
