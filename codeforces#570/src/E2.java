import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class E2 {
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
        int k = fr.nextInt();
        String s = fr.nextLine();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        int ans = 0;
        while (q.size() > 0 && set.size() < k) {
            HashSet<String> m = new HashSet<>();
            String str = q.remove();
            if (!set.contains(str)) {
                ans += s.length() - str.length();
                set.add(str);
            }
            for (int i = 0; i < str.length(); i++) {
                String t = str.substring(0, i) + str.substring(i + 1);
                if (!m.contains(t)) {
                    m.add(t);
                    q.add(t);
                }

            }
        }
        if (set.size() < k) System.out.println(-1);
        else System.out.println(ans);
    }
}