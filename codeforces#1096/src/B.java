import java.io.*;
import java.math.BigInteger;
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
        int m = 998244353;
        String s = fr.nextLine();
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            long count = 0;
            int i = 0;
            while (s.charAt(i) == s.charAt(i + 1)) {
                count = (count % m + 1 % m) % m;
                i++;
            }
            count = (count % m + 1 % m) % m;
            i = s.length() - 1;
            while (s.charAt(i) == s.charAt(i - 1)) {
                count = (count % m + 1 % m) % m;
                i--;
            }
            count = (count % m + 1 % m) % m;
            System.out.println((count % m + 1 % m) % m);
        } else {
            long count = 0;
            int l = 0;
            int r = s.length() - 1;

            while (l < r && s.charAt(l) == s.charAt(0)) l++;
            while (l < r && s.charAt(r) == s.charAt(0)) r--;
            int c1 = l;
            int c2 = s.length() - r - 1;

            long min = Math.min(c1, c2) + 1;
            count = ((min % m) * (min % m)) % m;
            long a = Math.max(c1, c2) - Math.min(c1, c2);
            long val = ((a % m) * (min % m)) % m;
            count = ((count % m) + (val % m)) % m;
            System.out.println(count % m);
        }

    }
}

