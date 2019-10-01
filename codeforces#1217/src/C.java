import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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

    static class pair {
        int d;
        int preidx;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            String s = fr.nextLine();
            ArrayList<Integer> ones = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') ones.add(i);
            }
            int ans = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int j = i;
                while (j >= 0) {
                    pair p = helper(j, i, ones, s);
                    int d = p.d;
                    if (d == -1) break;
                    if (i - j + 1 == d) {
                        ans++;
                        j--;
                    }
                    else if (d > i - j + 1) j = i - d + 1;
                    else j = p.preidx;
                }
            }
            System.out.println(ans);
        }
    }

    private static pair helper(int l, int r, ArrayList<Integer> ones, String s) {
        pair mp = new pair();
        int lidx = Collections.binarySearch(ones, l);
        if (lidx < 0) {
            lidx = -(lidx + 1);
        }
        if (lidx - 1 >= 0) mp.preidx = ones.get(lidx - 1);
        else mp.preidx = -1;
        int ridx = Collections.binarySearch(ones, r);
        if (ridx < 0) {
            ridx = -(ridx + 1) - 1;
        }

        int sum = 0;
        for (int i = lidx; i <= ridx; i++) {
            int p = r - ones.get(i);
            sum += Math.pow(2, p);
            if (p > 20 || sum > s.length() || sum < 0) {
                mp.d = -1;
                return mp;
            }
        }
        mp.d = sum;
        return mp;
    }
}
