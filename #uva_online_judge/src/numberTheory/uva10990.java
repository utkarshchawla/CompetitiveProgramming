package numberTheory;

import java.io.*;
import java.lang.annotation.ElementType;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10990 {
    private static int[] eulerPhi = new int[2000001];

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
        setEulerPhi();
        int[] depthEuler = new int[eulerPhi.length];
        depthEuler[1] = depthEuler[2] = 1;
        for (int i = 3; i < depthEuler.length; i++) {
            depthEuler[i] = depthEuler[eulerPhi[i]] + 1;
        }
        int[] sum = new int[depthEuler.length];
        sum[0] = depthEuler[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + depthEuler[i];
        }

        int t = fr.nextInt();
        while (t-- > 0) {
            int m = fr.nextInt();
            int n = fr.nextInt();
            fw.println(sum[n] - sum[m - 1]);
        }
        fw.close();
    }


    private static void setEulerPhi() {
        for (int i = 1; i < eulerPhi.length; i++) {
            eulerPhi[i] = i;
        }

        for (int i = 2; i < eulerPhi.length; i++) {
            if (eulerPhi[i] == i) {
                for (int j = i; j < eulerPhi.length; j += i) {
                    eulerPhi[j] = (eulerPhi[j] / i) * (i - 1);
                }
            }
        }
    }
}
