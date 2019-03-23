import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B {
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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 100000000);
        map.put("B", 100000000);
        map.put("C", 100000000);
        map.put("AB", 100000000);
        map.put("BC", 100000000);
        map.put("AC", 100000000);
        map.put("ABC", 100000000);
        for (int i = 0; i < n; i++) {
            int price = fr.nextInt();
            String s = fr.next();
            if (s.contains("A") && s.contains("B") && s.contains("C")) {
                map.put("ABC", Math.min(price, map.get("ABC")));
            } else if (s.contains("A") && s.contains("B")) {
                map.put("AB", Math.min(price, map.get("AB")));
            } else if (s.contains("A") && s.contains("C")) {
                map.put("AC", Math.min(price, map.get("AC")));
            } else if (s.contains("B") && s.contains("C")) {
                map.put("BC", Math.min(price, map.get("BC")));
            } else if (s.contains("A")) {
                map.put("A", Math.min(price, map.get("A")));
            } else if (s.contains("B")) {
                map.put(("B"), Math.min(price, map.get("B")));
            } else {
                map.put(("C"), Math.min(price, map.get("C")));
            }
        }
        int a = map.get("A") + map.get("B") + map.get("C");
        int b = map.get("AB") + map.get("C");
        int c = map.get("A") + map.get("BC");
        int d = map.get("AC") + map.get("B");
        int e = map.get("ABC");
        int f = map.get("AB") + map.get("BC");
        int g = map.get("AC") + map.get("BC");
        int h = map.get("AC") + map.get("AB");

        int ans = Math.min(a, Math.min(b, Math.min(c, Math.min(d, Math.min(e, Math.min(f, Math.min(g, h)))))));
        if (ans >= 100000000) System.out.println(-1);
        else System.out.println(ans);


    }
}
