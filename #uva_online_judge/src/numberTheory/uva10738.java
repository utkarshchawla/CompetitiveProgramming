package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10738 {

    static pair[] numDiff = new pair[1000001];

    static class pair {
        int n;
        boolean flag = true;

        pair(int n, boolean flag) {
            this.n = n;
            this.flag = flag;
        }
    }

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
        setNumDiff();
        int[] sum = new int[numDiff.length];
        sum[1] = numDiff[1].n;
        for (int i = 2; i < sum.length; i++) {
            sum[i] = sum[i - 1] + numDiff[i].n;
        }
        while (true) {
            int n = fr.nextInt();
            if (n == 0) break;
            System.out.printf("%8d%8d%8d", n, numDiff[n].n, sum[n]);
            System.out.println();
        }
    }

    public static void setNumDiff() {
        numDiff[1] = new pair(1, true);
        for (int i = 2; i < numDiff.length; i++) {
            numDiff[i] = new pair(0, true);
        }
        for (int i = 2; i < numDiff.length; i++) {
            if (numDiff[i].n == 0) {
                for (int j = i; j < numDiff.length; j += i) {
                    numDiff[j].n++;
                    int count = 0;
                    int temp = j;
                    while (temp % i == 0) {
                        count++;
                        temp /= i;
                    }
                    if (count > 1) {
                        numDiff[j].flag = false;
                    }
                }
            }
        }

        for (int i = 2; i < numDiff.length; i++) {
            if (!numDiff[i].flag) {
                numDiff[i].n = 0;
            } else {
                if (numDiff[i].n % 2 == 0) {
                    numDiff[i].n = 1;
                } else numDiff[i].n = -1;
            }
        }

    }
}
