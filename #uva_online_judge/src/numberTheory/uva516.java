package numberTheory;


import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva516 {
    public static boolean[] seive = new boolean[100000];

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
        ArrayList<Integer> primes = seiveGen();
        while (true) {
            int n = 1;
            String s = fr.nextLine();
            if (s.charAt(0) == '0') break;
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                n *= Math.pow(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }
            n--;
            ArrayList<Integer> PFactors = PrimeFactors(n, primes);
            StringBuilder ans = new StringBuilder();
            while (PFactors.size() > 0) {
                int val = PFactors.remove(PFactors.size() - 1);
                int count = 1;
                while (PFactors.size() > 0 && PFactors.get(PFactors.size() - 1) == val ) {
                    count++;
                    PFactors.remove(PFactors.size() - 1);
                }
                ans.append(val).append(" ").append(count).append(" ");
            }
            ans.deleteCharAt(ans.length() - 1);
            System.out.println(ans);
        }
    }

    private static ArrayList<Integer> PrimeFactors(int n, ArrayList<Integer> primes) {
        ArrayList<Integer> rl = new ArrayList<>();
        int idx = 0;
        while (primes.get(idx) * primes.get(idx) <= n) {
            while (n % primes.get(idx) == 0) {
                n /= primes.get(idx);
                rl.add(primes.get(idx));
            }
            idx++;
        }

        if (n != 1) {
            rl.add(n);
        }
        return rl;
    }

    private static ArrayList<Integer> seiveGen() {
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

}
