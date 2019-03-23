package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva10140 {
    private static boolean[] seive = new boolean[46350];

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
        Scanner scn = new Scanner(System.in);
        ArrayList<Long> primes = seiveGen();
        System.out.println(primes.get(primes.size() - 1));

        while (scn.hasNext()) {
            int l = scn.nextInt();
            int u = scn.nextInt();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int cl1 = -1, cl2 = -1, dl1 = -1, dl2 = -1;
            int prePrime = 0;
            for (int i = u; i >= l; i--) {
                if (isPrime(primes, i)) {
                    if (prePrime == 0) {
                        prePrime = i;
                        continue;
                    }
                    int diff = prePrime - i;
                    if (diff >= max) {
                        max = diff;
                        dl2 = prePrime;
                        dl1 = i;
                    }

                    if (diff <= min) {
                        min = diff;
                        cl2 = prePrime;
                        cl1 = i;
                    }
                    prePrime = i;
                }
            }

            if (cl1 == -1 || dl1 == -1) {
                System.out.println("There are no adjacent primes.");
            } else {
                System.out.println(cl1 + "," + cl2 + " are closest, " + dl1 + "," + dl2 + " are most distant.");
            }

        }


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

    public static boolean isPrime(ArrayList<Long> primes, int val) {
        if (val < seive.length) {
            return !seive[val];
        }

        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) > Math.sqrt(val)) return true; // ?
            if (val % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
}
