import java.io.*;
import java.math.BigInteger;
import java.rmi.ConnectIOException;
import java.util.InputMismatchException;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {
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
        int n = fr.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        boolean flag = false;
        for (int i : map.keySet()) {
            if (i == 0 || map.get(i) > 2) continue;
            if (!map.containsKey(i - 1)) {
                int size = map.size() + 1;
                if (map.get(i) == 1) size--;
                if (size == n)
                    flag = true;
            }
        }
        if (!flag) {
            System.out.println("cslnb");
            return;
        }
        long sum = 0;
        for (int i : map.keySet()) sum += i * 1L * map.get(i);
        sum -= (n) * (n - 1) / 2;
        if (sum % 2 != 0) {
            System.out.println("sjfnb");
        } else System.out.println("cslnb");
    }
}
