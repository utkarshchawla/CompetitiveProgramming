import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B {
    public static boolean[] seive;

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
        int l = fr.nextInt();
        int r = fr.nextInt();
        int x = fr.nextInt();
        int y = fr.nextInt();
        ArrayList<Long> primes = setSeive();
        HashMap<Long, Integer> mapa = PFactors(x, primes);
        HashMap<Long, Integer> mapb = PFactors(y, primes);
        HashMap<Long, Integer> map = new HashMap<>(mapa);
        for (long i : mapb.keySet()) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }

        if (x == 1) {
            HashSet<Long> set = new HashSet<>();
            set.addAll(mapa.keySet());
            set.addAll(mapb.keySet());
            set.add(1L);
            long ans = 0;
            for (long a : set) {
                double temp = (double) x / (double) a;
                long b = (long) (temp * y);
                if (b == 1 && a != 1) continue;
                if (a <= r && a >= l && b <= r && b >= l) {
                    long gcd = gcd(a, b);
                    if (gcd == x) {
                        if (a == b) ans++;
                        else ans += 2;
                    }
                }
            }
            System.out.println(ans);
        } else {
            if (x <= r && x >= l && y <= r && y >= l && y % x == 0) {
                System.out.println(2);
            } else System.out.println(0);
        }
    }

    public static HashMap<Long, Integer> PFactors(long n, ArrayList<Long> primes) {
        HashMap<Long, Integer> map = new HashMap<>();
        int idx = 0;
        while (idx < primes.size() && primes.get(idx) * primes.get(idx) <= n) {
            if (n % primes.get(idx) == 0) {
                int count = 0;
                while (n > 0 && n % primes.get(idx) == 0) {
                    count++;
                    n /= primes.get(idx);
                }
                map.put(primes.get(idx), count);
            }
            idx++;
        }

        if (n != 1) {
            map.put(n, 1);
        }

        return map;
    }

    public static ArrayList<Long> setSeive() {
        ArrayList<Long> primes = new ArrayList<>();
        seive = new boolean[10000000];
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

    public static long gcd(long A, long B) {
        if (A == 0) return B;
        return gcd(B % A, A);
    }

}
