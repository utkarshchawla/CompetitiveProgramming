import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C955 {
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
        int q = fr.nextInt();
        boolean[] arr = new boolean[100];
        ArrayList<Integer> list = new ArrayList<>();
        arr[0] = arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                for (int j = i * i * i; j < arr.length; j *= i) {
                    arr[j] = true;
                }
                list.add(i);
            }
        }

        for (Integer i : list) {
            int root = (int) Math.sqrt(i);
            if (root * root == i) list.remove(i);
        }
        while (q-- > 0) {
            long l = fr.nextLong();
            long u = fr.nextLong();
            int idx = 0;
//            long ans = 0;
            HashSet<Long> set = new HashSet<>();
            if (l == 1) {
                l++;
//                ans++;
                set.add(1L);
            }

            while (true) {
                double count = list.get(idx);
                double dres = Math.pow(l, 1.0 / count);
                double ires = Math.round(dres);
                double dif = Math.abs(dres - ires);
                long min = (long) Math.ceil(dres);
                if (dif < Math.ulp(10.0)) {
                    min = (long) ires;
                }

                dres = Math.pow(u, 1.0 / count);
                ires = Math.round(dres);
                dif = Math.abs(dres - ires);
                long max = (long) Math.floor(dres);
                if (dif < Math.ulp(10.0)) {
                    max = (long) ires;
                }

                long diff = 0;
                for (long i = min; i <= max; i++) {
                    if (Math.pow(i, count) > u)
                        System.out.println(i + " " + (int) count + "--" + Math.pow(i, count));
                    set.add((long) Math.pow(i, count));
                    diff++;
                }
                if (diff <= 0) break;
//                ans += diff;
                idx++;
            }
            long ans = (int) (set.size() + Math.sqrt(u) - Math.sqrt(l - 1));
            System.out.println(ans);
        }
    }


}
