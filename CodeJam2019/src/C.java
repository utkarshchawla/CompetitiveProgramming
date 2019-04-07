import java.io.*;
import java.math.BigInteger;
import java.util.*;

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            String s = fr.nextLine();
            int l = Integer.parseInt(s.split(" ")[1]);
            BigInteger[] arr = new BigInteger[l];
            for (int i = 0; i < arr.length; i++) arr[i] = BigInteger.valueOf(fr.nextInt());
            ArrayList<BigInteger> sol = new ArrayList<>();

            int count = 0;
            while (arr[count].equals(arr[count + 1])) count++;
            sol.add(arr[count].gcd(arr[count + 1]));
            for (int i = count + 1; i < arr.length; i++) {
                sol.add(arr[i].divide(sol.get(sol.size() - 1)));
            }
            for (int i = count; i >= 0; i--) {
                sol.add(0, arr[i].divide(sol.get(0)));
            }
            ArrayList<BigInteger> list = new ArrayList<>(new HashSet<>(sol));
            list.sort(null);
            HashMap<BigInteger, Character> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), (char) ('A' + i));
            }

            StringBuilder sb = new StringBuilder();
            for (BigInteger num : sol) {
                sb.append(map.get(num));
            }

            System.out.println("Case #" + c + ": " + sb);

        }
    }
}
