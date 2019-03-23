import com.sun.corba.se.impl.naming.cosnaming.InternalBindingValue;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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

    static class interval implements Comparable<interval> {
        int s;
        int e;

        interval(int s, int e) {
            this.e = e;
            this.s = s;
        }

        @Override
        public int compareTo(interval o) {
            return this.s - o.s;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, interval> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
            if (map.containsKey(arr[i])) map.get(arr[i]).e = i;
            else map.put(arr[i], new interval(i + 1, -1));
        }

        ArrayList<interval> intervals = new ArrayList<>();
        for (interval iv : map.values()) {
            if (iv.e != -1) intervals.add(iv);
        }
        intervals.sort(null);
        int i = 0;
        while (i < intervals.size() - 1) {
            if (intervals.get(i + 1).s <= intervals.get(i).e) {
                if (intervals.get(i + 1).e > intervals.get(i).e) {
                    intervals.get(i).e = intervals.get(i + 1).e;
                }
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        int c = 0;
        for (interval iv : intervals) {
            c += iv.e - iv.s + 1;
        }
        long pow = n - c - 1;
        BigInteger b = new BigInteger("2");
        BigInteger mod = new BigInteger("998244353");
        BigInteger exp = BigInteger.valueOf(pow);
        BigInteger result = b.modPow(exp, mod);
        System.out.println(result.toString());

    }
}
