import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static boolean[] seive = new boolean[100000];

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        ArrayList<Integer> primes = seivegen();
        for (int tc = 1; tc <= t; tc++) {
            int l = fr.nextInt();
            int r = fr.nextInt();
            int ans = 0;
            for (int i = l; i <= r; i++) {
                long nodd = 0;
                long neven = 0;
                HashMap<Integer, Integer> map = primefactor(i, primes);
                long val = 1;
                for (int v : map.values()) val *= (v + 1);
                if (i % 2 == 0) {
                    map = primefactor(i / 2, primes);
                    long eval = 1;
                    for (int v : map.values()) eval *= (v + 1);
                    neven = eval;
                    nodd = val - eval;
                } else {
                    nodd = val;
                }
                if (Math.abs(neven - nodd) <= 2) ans++;
            }
            System.out.println("Case #" + tc + ": " + ans);

        }
    }
}
