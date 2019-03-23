package cycleFInding;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva350 {
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
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int c = 1;
        while (true) {
            int z = fr.nextInt();
            int i = fr.nextInt();
            int m = fr.nextInt();
            int l = fr.nextInt();
            if (z == 0 && i == 0 && m == 0 && l == 0) break;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(l);
            for (int j = 0; j <= 10000; j++) {
                list.add((z * list.get(list.size() - 1) + i) % m);
            }

            int slow = 1;
            int fast = 2;
            while (!list.get(slow).equals(list.get(fast))) {
                slow++;
                fast += 2;
            }
            fast = 0;
            while (!list.get(slow).equals(list.get(fast))) {
                slow++;
                fast++;
            }
            fast = slow + 1;
            while (!list.get(slow).equals(list.get(fast))) {
                fast++;
            }
            fw.println("Case " + c + ": " + (fast - slow));
            c++;
        }
        fw.close();
    }
}
