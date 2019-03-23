package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class uva11371 {
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
        FastWriter fw = new FastWriter();
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String s = scn.nextLine();
            ArrayList<Character> list = new ArrayList<>();
            int cz = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') cz++;
                list.add(s.charAt(i));
            }
            list.sort(Collections.reverseOrder());
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                a.append(list.get(i));
                b.append(list.get(list.size() - i - 1));
            }

            while (b.charAt(0) == '0') {
                b.deleteCharAt(0);
            }
            while (cz > 0) {
                b.insert(1, 0);
                cz--;
            }

            long x = Long.parseLong(a.toString());
            long y = Long.parseLong(b.toString());

            long sub = x - y;
            fw.println(x + " - " + y + " = " + sub + " = " + "9 * " + sub / 9);
        }
        fw.close();
    }
}
