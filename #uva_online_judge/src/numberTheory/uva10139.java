package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class uva10139 {
    private static boolean seive[] = new boolean[70000];

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
        ArrayList<Long> primes = seivegen();
        while (scn.hasNext()) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            HashMap<Long, Long> map = factorial(primes, m);
            boolean flag = true;
            for (long p : map.keySet()) {
                if (map.get(p) > logExpo(n, p)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(m + " divides " + n + "!");
            } else {
                System.out.println(m + " does not divide " + n + "!");
            }
        }
    }

    private static int logExpo(int fact, long p) {
        int rv = 0;
        for (long i = p; i <= fact; i *= p) {
            rv += fact / i;
        }
        return rv;
    }

    private static HashMap<Long, Long> factorial(ArrayList<Long> primes, int val) {
        int idx = 0;
        HashMap<Long, Long> map = new HashMap<>();
        while (primes.get(idx) * primes.get(idx) <= val) {
            while (val % primes.get(idx) == 0) {
                val /= primes.get(idx);
                if (map.containsKey(primes.get(idx))) {
                    map.put(primes.get(idx), map.get(primes.get(idx)) + 1);
                } else {
                    map.put(primes.get(idx), 1L);
                }
            }
            idx++;
        }

        if (val != 1) {
            map.put((long) val, 1L);
        }

        return map;
    }

    private static ArrayList<Long> seivegen() {
        ArrayList<Long> primes = new ArrayList<>();
        seive[0] = true;
        seive[1] = true;
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
}
