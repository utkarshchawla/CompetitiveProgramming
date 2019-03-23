package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10110 {
    public static boolean seive[] = new boolean[1000000];

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
        while (true) {
            long n = fr.nextLong();
            if (n == 0) break;
            long ans = 1;
            HashMap<Long, Integer> map = primeFactors(n, primes);
            for (long i : map.keySet()) {
                ans *= (map.get(i) + 1);
            }

            if (ans % 2 == 0) {
                fw.println("no");
            } else {
                fw.println("yes");
            }
        }
        fw.close();
    }

    private static ArrayList<Long> seiveGen() {
        ArrayList<Long> primes = new ArrayList<>();
        seive[0] = seive[1] = true;
        for (long i = 2; i < seive.length; i++) {
            if (!seive[(int) i]) {
                for (long j = i * i; j < seive.length; j += i) {
                    seive[(int) j] = true;
                }
                primes.add(i);
            }
        }
        return primes;

    }

    private static HashMap<Long, Integer> primeFactors(long n, ArrayList<Long> primes) {
        int idx = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        while (primes.get(idx) * primes.get(idx) <= n) {
            int count = 0;
            while (n % primes.get(idx) == 0) {
                count++;
                n /= primes.get(idx);
            }
            if (count > 0) {
                map.put(primes.get(idx), count);
            }
            idx++;
        }
        if (n != 1) {
            map.put(n, 1);
        }
        return map;
    }
}
