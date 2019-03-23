package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10179 {
    private static boolean seive[] = new boolean[1000000];

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
        ArrayList<Integer> primes = seivegen();
        while (true) {
            int n = fr.nextInt();
            if (n == 0) break;
            fw.println(eulerTotient(primefactor(n, primes), n));
        }
        fw.close();
    }

    private static int eulerTotient(HashMap<Integer, Integer> map, int n) {
        int ans = n;
        for (int i : map.keySet()) {
            ans -= ans / i;
        }
        return ans;
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
