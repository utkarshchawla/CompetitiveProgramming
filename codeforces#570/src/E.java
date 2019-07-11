import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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

    public static int cost = 0;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        String s = fr.nextLine();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        for (int i = 1; i <= n; i++) {
            if (set.size() >= k) break;
            helper(s, set, -1, new HashSet<>(), i, i, k);
        }
        if (set.size() < k) System.out.println(-1);
        else System.out.println(cost);
    }

    public static void helper(String s, HashSet<String> set, int idx, HashSet<Integer> list, int n, int c, int k) {
        if (n == 0) {
            if (set.size() >= k) return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (list.contains(i)) continue;
                sb.append(s.charAt(i));
            }
            if (!set.contains(sb.toString())) {
                cost += c;
                set.add(sb.toString());
            }
            return;
        }
        for (int i = idx + 1; i < s.length(); i++) {
            list.add(i);
            helper(s, set, i, list, n - 1, c, k);
            list.remove(i);
        }
    }
}
