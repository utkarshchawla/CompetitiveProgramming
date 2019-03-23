import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int val = fr.nextInt();
            if (map.containsKey(val)) map.put(val, map.get(val) + 1);
            else map.put(val, 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        int ans = 0;
        int hi = 100;
        int lo = 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            boolean flag = helper(list, n, mid);
            if (flag) {
                lo = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                hi = mid - 1;
            }
        }
//        for (int i = 100; i > 0; i--) {
//            int k = 0;
//            for (int val : list) k += val / i;
//            if (k >= n) {
//                ans = i;
//                break;
//            }
//        }
        System.out.println(ans);
    }

    private static boolean helper(ArrayList<Integer> list, int n, int mid) {
        int k = 0;
        for (int val : list) k += val / mid;
        return k >= n;
    }
}
