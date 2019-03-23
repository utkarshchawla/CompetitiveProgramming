package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class uva11889 {
    public static boolean[] seive = new boolean[1000000];

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
        ArrayList<Integer> primes = seivegen();
        int tc = fr.nextInt();
        while (tc-- > 0) {
            int a = fr.nextInt();
            int c = fr.nextInt();
            HashMap<Integer, Integer> ma = primefactor(a, primes);
            HashMap<Integer, Integer> mc = primefactor(c, primes);
            HashMap<Integer, Integer> mb = new HashMap<>();
            for (int base : mc.keySet()) {
                if (ma.containsKey(base)) {
                    if (!Objects.equals(mc.get(base), ma.get(base))) {
                        mb.put(base, mc.get(base));
                    }
                } else {
                    mb.put(base, mc.get(base));
                }
            }

            int b = 1;
            for (int base : mb.keySet()) {
                b *= Math.pow(base, mb.get(base));
            }

            for (int val : ma.keySet()) {
                if (!mc.containsKey(val)) {
                    b = -1;
                } else {
                    if (ma.get(val) > mc.get(val)) {
                        b = -1;
                    }
                }
            }

            if (b < 0) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println(b);
            }
        }
    }

    private static ArrayList<Integer> seivegen() {
        ArrayList<Integer> primes = new ArrayList<>();
        seive[0] = seive[1] = true;
        for (long i = 2; i < seive.length; i++) {
            if (!seive[(int) i]) {
                for (long j = i * i; j < seive.length; j += i) {
                    seive[(int) j] = true;
                }
                primes.add((int) i);
            }
        }
        return primes;
    }

    private static HashMap<Integer, Integer> primefactor(int val, ArrayList<Integer> primes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        while (primes.get(idx) * primes.get(idx) <= val) {
            while (val % primes.get(idx) == 0) {
                val /= primes.get(idx);
                if (map.containsKey(primes.get(idx))) {
                    map.put(primes.get(idx), map.get(primes.get(idx)) + 1);
                } else {
                    map.put(primes.get(idx), 1);
                }
            }
            idx++;
        }

        if (val != 1) {
            map.put(val, 1);
        }
        return map;
    }
}
