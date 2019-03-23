import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
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
        int k = fr.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(arr[i])) list = map.get(arr[i]);
            list.add(i);
            map.put(arr[i], list);
        }

        int[] ans = new int[n];
        int c = 1;
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() > k) {
                System.out.println("NO");
                return;
            }
            for (int i : list) {
                if (c == 0) c++;
                ans[i] = c;
                c = (c + 1) % (k + 1);
            }
        }

        for (int i = 0; i < ans.length; i++) if (ans[i] == 0) ans[i] = 1;
        System.out.println("YES");
        for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
        System.out.println();
    }
}
