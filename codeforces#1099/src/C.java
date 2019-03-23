import jdk.nashorn.internal.ir.ContinueNode;

import java.io.*;
import java.math.BigInteger;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        String s = fr.nextLine();
        int n = fr.nextInt();
        int count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != '*' && s.charAt(i) != '?') count++;
        StringBuilder sb = new StringBuilder();
        if (count == n) {
            for (int i = 0; i < s.length(); i++) if (s.charAt(i) != '*' && s.charAt(i) != '?') sb.append(s.charAt(i));
            System.out.println(sb);
        } else if (count > n) {
            int diff = count - n;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*' || s.charAt(i) == '?') {
                    if (diff > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        diff--;
                    }
                } else sb.append(s.charAt(i));
            }
            if (diff == 0) System.out.println(sb);
            else System.out.println("Impossible");
        } else {
            int diff = n - count;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '?') continue;
                if (s.charAt(i) == '*') {
                    while (diff != 0) {
                        sb.append(sb.charAt(sb.length() - 1));
                        diff--;
                    }
                } else sb.append(s.charAt(i));
            }

            if (diff == 0) System.out.println(sb);
            else System.out.println("Impossible");
        }
    }
}
