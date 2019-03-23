package bigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva1210 {
    private static boolean[] seive = new boolean[10000];

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
        ArrayList<Long> primes = seiveGen();
//        System.out.println(primes.get(primes.size() - 1));
        while (true) {
            int n = fr.nextInt();
            BigInteger comp = new BigInteger(n + "");
            if (n == 0) break;
            int ans = 0;
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) > n) {
                    break;
                }
                BigInteger big = BigInteger.ZERO;
                for (int j = i; j < primes.size(); j++) {
                    big = big.add(new BigInteger(primes.get(j) + ""));
                    int val = big.compareTo(comp);
                    if (val == 0) {
                        ans++;
                    } else if (val > 0) {
                        break;
                    }
                }
            }
            fw.println(ans);
        }
        fw.close();
    }

    public static ArrayList<Long> seiveGen() {
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
