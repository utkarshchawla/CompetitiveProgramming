package A1;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class PERIODIC {
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
        o:
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = fr.nextInt();
                if (arr[i] != -1) {
                    ArrayList<Integer> list = new ArrayList<>();
                    if (map.containsKey(arr[i])) list = map.get(arr[i]);
                    list.add(i);
                    map.put(arr[i], list);
                }
            }
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == -1 || arr[i + 1] == -1) continue;
                if (arr[i + 1] != arr[i] + 1) {
                    System.out.println("impossible");
                    continue o;
                }

            }
            int k = -1;
            for (ArrayList<Integer> l : map.values()) {
                if (l.size() > 1) {
                    k = l.get(1) - l.get(0);
                }
            }
            if(k == -1){

            }
        }
    }
}
