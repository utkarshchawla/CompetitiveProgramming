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
        int q = fr.nextInt();
        while (q-- > 0) {
            int n = fr.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int t = fr.nextInt();
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
            ArrayList<Integer> list = new ArrayList<>(map.values());
            list.sort(Collections.reverseOrder());
            int p = list.get(0);
            int ans = p;
            for (int i = 1; i < list.size(); i++) {
                if (p <= 0) break;
                if (list.get(i) < p) {
                    ans += list.get(i);
                    p = list.get(i);
                } else {
                    ans += p - 1;
                    p--;
                }
            }

            System.out.println(ans);
        }
    }
}
