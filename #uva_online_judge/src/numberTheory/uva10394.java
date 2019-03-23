package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva10394 {
    private static boolean[] seive = new boolean[20000000];

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

        FastWriter fw = new FastWriter();
        Scanner scn = new Scanner(System.in);
        ArrayList<Long> seive = seiveGen();
        long[] arr = new long[100001];
        int idx = 1;
        for (int i = 0; i < seive.size() - 1; i++) {
            if (seive.get(i + 1) - seive.get(i) == 2) {
                arr[idx] = seive.get(i);
                idx++;
                if (idx > 100000) {
                    break;
                }
            }
        }
        while (scn.hasNext()) {
            int n = scn.nextInt();
            System.out.println("(" + arr[n] + ", " + (arr[n] + 2) + ")");
        }
    }

    private static ArrayList<Long> seiveGen() {
        ArrayList<Long> rlist = new ArrayList<>();
        seive[0] = true;
        seive[1] = true;
        for (long i = 2; i < seive.length; i++) {
            if (!seive[(int) i]) {
                for (long j = i * i; j < seive.length; j += i) {
                    seive[(int) j] = true;
                }
                rlist.add(i);
            }
        }
        return rlist;
    }

}
