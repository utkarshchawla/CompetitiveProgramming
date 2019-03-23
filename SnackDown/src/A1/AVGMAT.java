package A1;

import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class AVGMAT {
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
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int ans = 0;
            HashSet<String> set = new HashSet<>();
            while (n-- > 0) {
                int count = 0;
                String s = fr.nextLine();
                count += 2;
                boolean hand = true;
                if (s.charAt(0) == 'd' || s.charAt(0) == 'f') hand = false;
                for (int i = 1; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (ch == 'd' || ch == 'f') {
                        if (hand) {
                            count += 2;
                            hand = false;
                        } else {
                            count += 4;
                        }
                    } else {
                        if (hand) {
                            count += 4;
                        } else {
                            count += 2;
                            hand = true;
                        }
                    }
                }
                if (set.contains(s)) ans += count / 2;
                else {
                    ans += count;
                    set.add(s);
                }
            }
            System.out.println(ans);

        }
    }
}
